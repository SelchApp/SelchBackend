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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.github.selchapp.api.model.GPRSPosition;
import io.github.selchapp.api.model.User;
import io.github.selchapp.api.model.UserRepository;
import io.github.selchapp.api.util.JsonWrapper;

@RestController
public class RouteController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(RouteController.class);
	
	@Autowired
	private UserRepository userRepository;
	
	@RequestMapping(method=RequestMethod.POST, path="route/touser/{userId}")
	public JsonWrapper getRoute(@PathVariable(name="userId", required=true) long userId, @RequestBody GPRSPosition selfPosition) throws URISyntaxException, UnsupportedOperationException, IOException {
		User destinationUser = userRepository.findById(userId);
		
		Optional<GPRSPosition> sourcePosition = Optional.ofNullable(selfPosition).filter(GPRSPosition::isValid);
		Optional<GPRSPosition> destinationPosition = Optional.ofNullable(destinationUser).map(User::getCurrentPosition).filter(GPRSPosition::isValid);
		
		logPosition("source", sourcePosition);
		logPosition("destination", destinationPosition);
		
		if (!sourcePosition.isPresent() || !destinationPosition.isPresent()) {
			throw new IllegalArgumentException("The given coordinates are not valid for a routing request.");
		}
		
		CloseableHttpClient httpClient = HttpClients.createDefault();
		try {
			URI queryUri = new URIBuilder()
				.setScheme("http")
				.setHost("localhost")
				.setPort(15235)
				.setPath("query")
				.addParameter("slat", Double.toString(sourcePosition.get().getLat()))
				.addParameter("slng", Double.toString(sourcePosition.get().getLng()))
				.addParameter("tlat", Double.toString(destinationPosition.get().getLat()))
				.addParameter("tlng", Double.toString(destinationPosition.get().getLng()))
				.build();
			LOGGER.debug("Request to routing backend via URI {}", queryUri);
			
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
			
			String body = IOUtils.toString(result.getEntity().getContent(), Charset.defaultCharset());
			LOGGER.debug("Received response from routing backend:\n{}", body);
			return new JsonWrapper(body);
		} finally {
			IOUtils.closeQuietly(httpClient);
		}
	}

	private void logPosition(String description, Optional<GPRSPosition> sourcePosition) {
		if (!sourcePosition.isPresent()) {
			LOGGER.warn("{} position is invalid.", description);
		} else {
			LOGGER.debug("{} position: {}", description, sourcePosition.get());
		}
	}

}
