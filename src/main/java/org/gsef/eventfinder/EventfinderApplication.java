package org.gsef.eventfinder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories("org.gsef.eventfinder.jpa.repo")
@EntityScan("org.gsef.eventfinder.jpa.model")
@ComponentScan
@SpringBootApplication
public class EventfinderApplication {

	public static void main(String[] args) {
		SpringApplication.run(EventfinderApplication.class, args);
	}
}
