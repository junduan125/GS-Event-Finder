package org.gsef.eventfinder.graphql.query;

import java.util.ArrayList;
import java.util.List;

import org.gsef.eventfinder.jpa.model.GSEvent;
import org.gsef.eventfinder.jpa.model.GSUser;
import org.gsef.eventfinder.jpa.model.UserCharacter;
import org.gsef.eventfinder.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;

@Component
public class Query implements GraphQLQueryResolver  {
	
	@Autowired
	private UserService userService;
	
	private static UserDetails getAuthenticatedUser() {
		return (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	}
	
	public Query() {}

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
