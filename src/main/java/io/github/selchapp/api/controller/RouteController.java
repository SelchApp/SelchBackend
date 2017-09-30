package io.github.selchapp.api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import io.github.selchapp.api.model.GPRSPosition;
import io.github.selchapp.api.model.Route;

@Controller
public class RouteController {
	
	@RequestMapping(method=RequestMethod.GET, path="route/touser")
	@ResponseBody
	public Route getRoute(@RequestParam int userId, @RequestParam GPRSPosition selfPosition) {
		return null;
	}
	
}
