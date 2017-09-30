package io.github.selchapp.api.controller;

import javax.websocket.server.PathParam;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import io.github.selchapp.api.model.GPRSPosition;

@Controller
public class PositionController {

	@RequestMapping(method=RequestMethod.GET, path="position/self")
	@ResponseBody
	public GPRSPosition getSelfPosition() {
		GPRSPosition position = new GPRSPosition();
		position.setLatitude(47.4917816);
		position.setLongitude(12.2715673);
		return position;
	}
	
	@RequestMapping(method=RequestMethod.PUT, path="position/self")
	@ResponseBody
	public void setSelfPosition(@RequestParam GPRSPosition newPosition) {

	}
	
	@RequestMapping(method=RequestMethod.GET, path="position/user/{userid}")
	@ResponseBody
	public GPRSPosition getUserPosition(@PathParam("userid") int userId) {
		GPRSPosition position = new GPRSPosition();
		position.setLatitude(47.4943406);
		position.setLongitude(12.2655373);
		return position;
	}
	
}
