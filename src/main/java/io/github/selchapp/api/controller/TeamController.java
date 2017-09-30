package io.github.selchapp.api.controller;

import java.util.Arrays;
import java.util.Collection;

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

	@RequestMapping(method=RequestMethod.GET, path="/team/{teamId}")
    public Team getTeam(@PathVariable("teamId") long teamId) {
//		Team team = teamRepository.findById(teamId);
//		if (team == null) {
//			throw new EntityNotFoundException();
//		}
//		return team;
		Team team = new Team();
		team.setId(1);
		team.setName("Selchs");
		User user1 = new User();
		user1.setId(1l);
		user1.setNickname("Stephan");
		user1.setTeams(Arrays.asList(team));
		User user2 = new User();
		user2.setId(1l);
		user2.setNickname("Valentin");
		user2.setTeams(Arrays.asList(team));
		team.setUsers(Arrays.asList(user1, user2));
		return team;
		
	}
	
}
