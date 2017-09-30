package io.github.selchapp.api.model;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String nickname;
	
	private String password;
	
	@ManyToMany(mappedBy="users")
	private Collection<Team> teams;
	
	//private GPRSPosition currentPosition;

	public void setId(Long id) {
		this.id = id;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Collection<Team> getTeams() {
		return teams;
	}

	public void setTeams(Collection<Team> teams) {
		this.teams = teams;
	}

//	public GPRSPosition getCurrentPosition() {
//		return currentPosition;
//	}
//
//	public void setCurrentPosition(GPRSPosition currentPosition) {
//		this.currentPosition = currentPosition;
//	}
	
	
	
}
