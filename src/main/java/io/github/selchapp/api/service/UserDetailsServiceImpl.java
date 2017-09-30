package io.github.selchapp.api.service;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.github.selchapp.api.model.User;
import io.github.selchapp.api.model.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByNickname(username);
		if (user == null) {
			throw new UsernameNotFoundException(String.format("User %s not found.", username));
		}

		Collection<GrantedAuthority> authorities = new ArrayList<>();
		authorities.add(new SimpleGrantedAuthority("default"));
		if ("test".equals(username)) {
			authorities.add(new SimpleGrantedAuthority("ACTUATOR"));
		}
		return new org.springframework.security.core.userdetails.User(username, user.getPassword(), authorities);

	}

}
