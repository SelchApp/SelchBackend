package io.github.selchapp.api.model;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Team {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String name;

	@ManyToMany
	@JoinTable(name = "team_members", joinColumns = @JoinColumn(name = "team_id", referencedColumnName = "ID"), inverseJoinColumns = @JoinColumn(name = "member_id", referencedColumnName = "ID"))
	private Collection<User> users;

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Collection<User> getUsers() {
		return users;
	}

	public void setUsers(Collection<User> users) {
		this.users = users;
	}

}
