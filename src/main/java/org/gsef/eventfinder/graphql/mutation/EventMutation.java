package org.gsef.eventfinder.graphql.mutation;

import org.gsef.eventfinder.jpa.model.GSEvent;
import org.gsef.eventfinder.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;

@Component
public class EventMutation implements GraphQLMutationResolver {
	
	@Autowired
	private EventService eventService;

	public GSEvent createEvent(Long eventTime, Integer eventType) {
		return null;
	}

	public GSEvent joinEvent(Long id) {
		return null;
	}
	
	public Boolean leaveEvent(Long id) {
		return false;
	}
}
