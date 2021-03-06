package org.gsef.eventfinder.graphql.query;

import java.util.ArrayList;
import java.util.List;

import org.apache.tomcat.util.codec.binary.Base64;
import org.gsef.eventfinder.graphql.query.model.Node;
import org.gsef.eventfinder.jpa.model.GSUser;
import org.gsef.eventfinder.jpa.model.UserCharacter;
import org.gsef.eventfinder.service.EventService;
import org.gsef.eventfinder.service.UserProfileService;
import org.gsef.eventfinder.service.UserService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

public class GSProfile implements Node {
	
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
	
	@Override
	public String getId() {
		Long id = getUser().getId();
		return Base64.encodeBase64URLSafeString(Long.toString(id).getBytes());
	}
	
	public GSUser getUser() {
		UserDetails user = getAuthenticatedUser();
		return userService.findByUserName(user.getUsername());
	}
	
	public List<UserCharacter> getCharacters() {
		GSUser guser = userService.findByUserName(getAuthenticatedUser().getUsername());
		return userProfileService.ownedCharacters(guser);
	}
	
	public GSEventEdgeConnection getEvents(Integer first, Integer after) {
		System.out.println("first " + first + " after " + after);
		return eventService.listEvents(first, after, new ArrayList<>(), null, null, true);
	}
}
