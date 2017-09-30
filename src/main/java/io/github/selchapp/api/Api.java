package io.github.selchapp.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
@SpringBootApplication
public class Api 
{

	public static void main(String[] args) throws Exception {
        SpringApplication.run(Api.class, args);
    }
	
}
