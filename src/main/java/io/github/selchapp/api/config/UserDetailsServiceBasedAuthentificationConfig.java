package io.github.selchapp.api.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
public class UserDetailsServiceBasedAuthentificationConfig extends GlobalAuthenticationConfigurerAdapter  {
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Override
	  public void init(AuthenticationManagerBuilder auth) throws Exception {
	    auth.userDetailsService(userDetailsService);
	}
	
}
