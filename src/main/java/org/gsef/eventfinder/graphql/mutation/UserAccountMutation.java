package org.gsef.eventfinder.graphql.mutation;

import org.gsef.eventfinder.jpa.model.GSUser;
import org.gsef.eventfinder.jpa.model.UserCharacter.CharacterType;
import org.gsef.eventfinder.service.UserProfileService;
import org.gsef.eventfinder.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;

@Component
public class UserAccountMutation implements GraphQLMutationResolver {

	@Autowired
	private UserService userService;

	@Autowired
	private UserProfileService userProfileService;

	public GSUser addUserCharacter(Integer characterType, Integer level) {
		GSUser guser = userService.findByUserName(Mutation.getAuthenticatedUser().getUsername());
		return userProfileService.addCharacter(CharacterType.values()[characterType], level, guser);
	}

	public GSUser editUserCharacter(Integer characterType, Integer level) {
		GSUser guser = userService.findByUserName(Mutation.getAuthenticatedUser().getUsername());
		return null;
	}

	public GSUser removeUserCharacter(Integer characterType) {
		GSUser guser = userService.findByUserName(Mutation.getAuthenticatedUser().getUsername());
		return userProfileService.removeCharacter(CharacterType.values()[characterType], guser);
	}
}
