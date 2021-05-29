package org.gsef.eventfinder.graphql.mutation;

import org.gsef.eventfinder.jpa.model.GSUser;
import org.gsef.eventfinder.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;

@Component
public class UserAccountMutation implements GraphQLMutationResolver {

	@Autowired
	private UserService userService;

	public GSUser addUserCharacter(Integer characterType, Integer level) {
		return null;
	}

	public GSUser editUserCharacter(Long id, Integer characterType) {
		return null;
	}

	public GSUser removeUserCharacter(Long id) {
		return null;
	}
}
