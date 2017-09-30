package io.github.selchapp.api.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
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

		System.out.println(username);
		User user = userRepository.findByNickname(username);
		if (user == null) {
			throw new UsernameNotFoundException(String.format("User %s not found.", username));
		}
		System.out.println(user);
		
		SimpleGrantedAuthority authority = new SimpleGrantedAuthority("default");

		return new org.springframework.security.core.userdetails.User(username, user.getPassword(),
				Arrays.asList(authority));

	}

}
