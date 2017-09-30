package io.github.selchapp.api.model;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team, Long> {

	Team findById(long id);
	
}
