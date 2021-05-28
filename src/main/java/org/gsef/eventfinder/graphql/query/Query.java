package org.gsef.eventfinder.graphql.query;

import java.util.ArrayList;
import java.util.List;

import org.gsef.eventfinder.jpa.model.GSEvent;
import org.gsef.eventfinder.jpa.model.GSUser;
import org.gsef.eventfinder.jpa.model.UserCharacter;
import org.gsef.eventfinder.service.UserService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;

public class Query implements GraphQLQueryResolver  {
	
	private UserService userService;
	
	private static UserDetails getAuthenticatedUser() {
		return (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	}
	
	public Query() {}
	
	public Query(UserService userService) {
		this.userService = userService;
	}

	public GSUser getProfile() {
		UserDetails user = getAuthenticatedUser();
		return userService.findByUserName(user.getUsername());
	}
	
	public List<UserCharacter> getCharacters() {
		return new ArrayList<>();
	}
	
	public List<GSEvent> getEvents() {
		return new ArrayList<>();
	}
}
