package io.github.selchapp.api.controller;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.util.Optional;

import org.apache.commons.io.IOUtils;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import io.github.selchapp.api.model.GPRSPosition;
import io.github.selchapp.api.model.User;
import io.github.selchapp.api.model.UserRepository;

@Controller
public class RouteController {

	@Autowired
	private UserRepository userRepository;
	
	@RequestMapping(method=RequestMethod.GET, path="route/touser/{userId}", produces="application/json")
	@ResponseBody
	public String getRoute(@PathVariable(name="userId", required=true) long userId, @RequestParam GPRSPosition selfPosition) throws URISyntaxException, UnsupportedOperationException, IOException {
		User destinationUser = userRepository.findById(userId);
		
		Optional<GPRSPosition> sourcePosition = Optional.ofNullable(selfPosition).filter(GPRSPosition::isValid);
		Optional<GPRSPosition> destinationPosition = Optional.ofNullable(destinationUser).map(User::getCurrentPosition).filter(GPRSPosition::isValid);
		
		if (!sourcePosition.isPresent() || !destinationPosition.isPresent()) {
			throw new IllegalArgumentException("The given coordinates are not valid for a routing request.");
		}
		
		CloseableHttpClient httpClient = HttpClients.createDefault();
		try {
			URI queryUri = new URIBuilder()
				.setHost("localhost")
				.setPort(15235)
				.setPath("query")
				.addParameter("slat", Double.toString(sourcePosition.get().getLatitude()))
				.addParameter("slng", Double.toString(sourcePosition.get().getLongitude()))
				.addParameter("tlat", Double.toString(destinationPosition.get().getLatitude()))
				.addParameter("tlng", Double.toString(destinationPosition.get().getLongitude()))
				.build();
			
			HttpGet getRequest = new HttpGet(queryUri);
			CloseableHttpResponse result;
			try {
				result = httpClient.execute(getRequest);
			} catch (IOException e) {
				throw new IllegalStateException(String.format("Could not contact backend service via %s", queryUri.toString()), e);
			}
			int statusCode = Optional.ofNullable(result).map(CloseableHttpResponse::getStatusLine).map(StatusLine::getStatusCode).orElse(500);
			if (statusCode != 200) {
				throw new IllegalStateException(String.format("Processing in backend service failed %s", statusCode));
			}
			
			return IOUtils.toString(result.getEntity().getContent(), Charset.defaultCharset());
		} finally {
			IOUtils.closeQuietly(httpClient);
		}
	}

}
