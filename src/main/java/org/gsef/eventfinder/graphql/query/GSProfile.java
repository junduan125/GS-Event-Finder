package org.gsef.eventfinder.graphql.query;

import java.util.List;

import org.gsef.eventfinder.jpa.model.GSEvent;
import org.gsef.eventfinder.jpa.model.GSUser;
import org.gsef.eventfinder.jpa.model.UserCharacter;
import org.gsef.eventfinder.service.EventService;
import org.gsef.eventfinder.service.UserProfileService;
import org.gsef.eventfinder.service.UserService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

public class GSProfile {
	
	private UserService userService;
	private UserProfileService userProfileService;
	private EventService eventService;
	
	public GSProfile (UserService userService, UserProfileService userProfileService, EventService eventService) {
		this.userService = userService;
		this.userProfileService = userProfileService;
		this.eventService = eventService;
	}
	
	private static UserDetails getAuthenticatedUser() {
		return (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	}
	
	public GSUser getUser() {
		UserDetails user = getAuthenticatedUser();
		return userService.findByUserName(user.getUsername());
	}
	
	public List<UserCharacter> getCharacters() {
		GSUser guser = userService.findByUserName(getAuthenticatedUser().getUsername());
		return userProfileService.ownedCharacters(guser);
	}
	
	public List<GSEvent> getEvents() {
		return eventService.listEvents();
	}
}
