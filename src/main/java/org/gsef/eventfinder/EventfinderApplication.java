package org.gsef.eventfinder;

import org.gsef.eventfinder.graphql.mutation.Mutation;
import org.gsef.eventfinder.graphql.query.Query;
import org.gsef.eventfinder.service.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories("org.gsef.eventfinder.jpa.repo")
@EntityScan("org.gsef.eventfinder.jpa.model")
@SpringBootApplication
public class EventfinderApplication {

	public static void main(String[] args) {
		SpringApplication.run(EventfinderApplication.class, args);
	}
	
	@Bean
	public Query query(UserService userService) {
		return new Query(userService);
	}

	@Bean
	public Mutation mutation() {
		return new Mutation();
	}
}
