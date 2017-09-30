package io.github.selchapp.api.controller;

import java.util.Collection;

import javax.persistence.EntityNotFoundException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.github.selchapp.api.model.Team;
import io.github.selchapp.api.model.TeamRepository;
import io.github.selchapp.api.model.User;

@RestController
public class TeamController {

	@Autowired
	private TeamRepository teamRepository;

	@RequestMapping(method=RequestMethod.GET, path="/team/{teamId}/members")
    public Collection<User> getUsers(@PathVariable("teamId") long teamId) {
		Team team = teamRepository.findById(teamId);
		if (team == null) {
			throw new EntityNotFoundException();
		}
		return team.getUsers();
	}
	
}
