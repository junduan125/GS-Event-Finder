package org.gsef.eventfinder.graphql.mutation;

import org.gsef.eventfinder.jpa.model.GSEvent;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;

public class EventMutation implements GraphQLMutationResolver {

	public GSEvent createEvent(Long eventTime) {
		return null;
	}
	
	public GSEvent joinEvent(Long id) {
		return null;
	}
	
	public Boolean leaveEvent(Long id) {
		return null;
	}
}
