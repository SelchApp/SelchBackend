package io.github.selchapp.api.controller;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.github.selchapp.api.model.User;
import io.github.selchapp.api.model.UserRepository;

@RestController
public class UserController {

	@Autowired
	private UserRepository userRepository;
	
	@RequestMapping(method=RequestMethod.GET, path="/user/{userId}")
    public User getTeam(@PathVariable(name="userId", required=true) long userId) {
		User user = userRepository.findById(userId);
		if (user == null) {
			throw new EntityNotFoundException();
		}
		return user;
	}
	
}
