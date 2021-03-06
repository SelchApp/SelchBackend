package io.github.selchapp.api.controller;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.github.selchapp.api.model.Team;
import io.github.selchapp.api.model.TeamRepository;

@RestController
public class TeamController {

	@Autowired
	private TeamRepository teamRepository;

	@RequestMapping(method=RequestMethod.GET, path="/team/{teamId}")
    public Team getTeam(@PathVariable(name="teamId", required=true) long teamId) {
		Team team = teamRepository.findById(teamId);
		if (team == null) {
			throw new EntityNotFoundException();
		}
		return team;
	}
	
}
