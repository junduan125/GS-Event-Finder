package org.gsef.eventfinder.graphql.mutation;

import org.gsef.eventfinder.service.EventService;
import org.gsef.eventfinder.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;

@Component
public class Mutation implements GraphQLMutationResolver {

	@Autowired
	UserService userService;

	@Autowired
	EventService eventService;

	public static UserDetails getAuthenticatedUser() {
		return (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	}

	public Boolean rateUser(Long id, Integer overall, Boolean griefed, Boolean flaked) {
		return false;
	}
}
