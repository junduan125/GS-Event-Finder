package org.gsef.eventfinder.graphql.mutation;

import java.util.Date;

import org.gsef.eventfinder.exception.UserAlreadyJoinedException;
import org.gsef.eventfinder.exception.UserExceedEventMaximumException;
import org.gsef.eventfinder.graphql.query.model.GSEvent;
import org.gsef.eventfinder.jpa.model.GSEvent.GSEventType;
import org.gsef.eventfinder.jpa.model.GSUser;
import org.gsef.eventfinder.service.EventService;
import org.gsef.eventfinder.service.UserService;
import org.gsef.eventfinder.utils.IdDecoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;

@Component
public class EventMutation implements GraphQLMutationResolver {
	
	@Autowired
	private UserService userService;
	@Autowired
	private EventService eventService;

	public GSEvent createEvent(Long eventTime, Integer eventType, Integer characterType, Integer minWorldLevel) throws UserExceedEventMaximumException, UserAlreadyJoinedException {
		GSEvent gsEvent = new GSEvent(eventService.createEvent(new Date(eventTime * 1000), GSEventType.values()[eventType], minWorldLevel));
		return joinEvent(IdDecoder.decode(gsEvent.getId()), characterType);
	}

	public GSEvent joinEvent(Long id, Integer characterType) throws UserExceedEventMaximumException, UserAlreadyJoinedException {
		GSUser guser = userService.findByUserName(Mutation.getAuthenticatedUser().getUsername());
		return new GSEvent(eventService.joinEvent(id, guser, characterType.longValue()));
	}
	
	public Boolean leaveEvent(Long id) {
		GSUser guser = userService.findByUserName(Mutation.getAuthenticatedUser().getUsername());
		return eventService.leaveEvent(id, guser);
	}
}
