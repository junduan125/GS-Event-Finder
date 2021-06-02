package org.gsef.eventfinder.graphql.mutation;

import java.util.Date;

import org.gsef.eventfinder.exception.UserExceedEventMaximumException;
import org.gsef.eventfinder.jpa.model.GSEvent;
import org.gsef.eventfinder.jpa.model.GSUser;
import org.gsef.eventfinder.jpa.model.GSEvent.GSEventType;
import org.gsef.eventfinder.service.EventService;
import org.gsef.eventfinder.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;

@Component
public class EventMutation implements GraphQLMutationResolver {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private EventService eventService;

	public GSEvent createEvent(Long eventTime, Integer eventType) {
		return eventService.createEvent(new Date(eventTime * 1000), GSEventType.values()[eventType]);
	}

	public GSEvent joinEvent(Long id) throws UserExceedEventMaximumException {
		GSUser guser = userService.findByUserName(Mutation.getAuthenticatedUser().getUsername());
		return eventService.joinEvent(id, guser);
	}
	
	public Boolean leaveEvent(Long id) {
		GSUser guser = userService.findByUserName(Mutation.getAuthenticatedUser().getUsername());
		return eventService.leaveEvent(id, guser);
	}
}
