package io.github.selchapp.api.model;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
	
	User findById(long id);
    User findByNickname(String username);
}
