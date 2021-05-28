package org.gsef.eventfinder.graphql.mutation;

import org.gsef.eventfinder.jpa.model.GSEvent;
import org.gsef.eventfinder.jpa.model.GSUser;
import org.gsef.eventfinder.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;

public class Mutation implements GraphQLMutationResolver {
	
	@Autowired
	UserService userService;
	
	public GSUser addUserCharacter(Integer characterType, Integer level) {
		return null;
	}
	
	public GSUser editUserCharacter(Long id, Integer characterType) {
		return null;
	}
	
	public GSUser removeUserCharacter(Long id) {
		return null;
	}
	
	public Boolean rateUser(Long id, Integer overall, Boolean griefed, Boolean flaked) {
		return false;
	}
	
	public GSEvent createEvent(Long eventTime) {
		return null;
	}
	
	public GSEvent joinEvent(Long id) {
		return null;
	}
	
	public Boolean leaveEvent(Long id) {
		return false;
	}
}
