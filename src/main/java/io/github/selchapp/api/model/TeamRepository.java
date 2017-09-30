package io.github.selchapp.api.model;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<User, Long> {

	public Team findById(long id);
	
}
