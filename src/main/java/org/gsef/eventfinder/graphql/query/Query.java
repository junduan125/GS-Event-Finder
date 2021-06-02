package org.gsef.eventfinder.graphql.query;

import org.gsef.eventfinder.service.EventService;
import org.gsef.eventfinder.service.UserProfileService;
import org.gsef.eventfinder.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;

@Component
public class Query implements GraphQLQueryResolver  {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserProfileService userProfileService;
	
	@Autowired
	private EventService eventService;
	
	public Query() {}
	
	public GSProfile getProfile() {
		return new GSProfile(userService, userProfileService, eventService);
	}
}
