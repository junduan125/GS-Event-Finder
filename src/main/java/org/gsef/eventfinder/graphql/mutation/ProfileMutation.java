package org.gsef.eventfinder.graphql.mutation;

import org.gsef.eventfinder.jpa.model.GSUser;
import org.gsef.eventfinder.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;

public class ProfileMutation implements GraphQLMutationResolver {
	
	@Autowired
	UserService userService;
	
	public GSUser addUserCharacter() {
		return null;
	}
	
	public GSUser editUserCharacter() {
		return null;
	}
	
	public GSUser removeUserCharacter() {
		return null;
	}
	
	public Boolean rateUser(Long id, Integer overall, Boolean griefed, Boolean flaked) {
		return false;
	}
}
