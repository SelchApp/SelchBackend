package io.github.selchapp.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.github.selchapp.api.model.GPRSPosition;
import io.github.selchapp.api.model.User;
import io.github.selchapp.api.model.UserRepository;

@RestController
public class PositionController {

	@Autowired
	private UserRepository userRepository;
	
	@RequestMapping(method=RequestMethod.GET, path="position/self")
	public GPRSPosition getSelfPosition(@AuthenticationPrincipal final UserDetails userDetails) {
		String username = userDetails.getUsername();
		User user = userRepository.findByNickname(username);
		return user.getCurrentPosition();
	}
	
	@RequestMapping(method=RequestMethod.POST, path="position/self")
	public void setSelfPosition(@RequestBody(required=true) GPRSPosition newPosition, @AuthenticationPrincipal final UserDetails userDetails) {
		String username = userDetails.getUsername();
		User user = userRepository.findByNickname(username);
		user.setCurrentPosition(newPosition);
		userRepository.save(user);
	}
	
	@RequestMapping(method=RequestMethod.GET, path="position/user/{userid}")
	public GPRSPosition getUserPosition(@PathVariable(name="userid", required=true) long userId) {
		User user = userRepository.findById(userId);
		return user.getCurrentPosition();
	}
	
}
