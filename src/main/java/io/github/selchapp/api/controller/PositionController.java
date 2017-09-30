package io.github.selchapp.api.controller;

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
		return null;
	}
	
	@RequestMapping(method=RequestMethod.PUT, path="position/self")
	@ResponseBody
	public void setSelfPosition(@RequestParam GPRSPosition newPosition) {

	}
	
	@RequestMapping(method=RequestMethod.GET, path="position/user")
	@ResponseBody
	public GPRSPosition getUserPosition(@RequestParam int userId) {
		return null;
	}
	
}
