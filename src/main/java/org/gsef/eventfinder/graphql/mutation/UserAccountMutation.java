package org.gsef.eventfinder.graphql.mutation;

import java.util.List;

import org.gsef.eventfinder.jpa.model.GSUser;
import org.gsef.eventfinder.jpa.model.UserCharacter;
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

	public List<UserCharacter> addUserCharacter(Integer characterType, Integer level) {
		GSUser guser = userService.findByUserName(Mutation.getAuthenticatedUser().getUsername());
		return userProfileService.addCharacter(characterType.longValue(), level, guser);
	}

	public UserCharacter editUserCharacter(Integer characterType, Integer level) {
		GSUser guser = userService.findByUserName(Mutation.getAuthenticatedUser().getUsername());
		return userProfileService.editCharacter(characterType.longValue(), level, guser);
	}

	public List<UserCharacter> removeUserCharacter(Integer characterType) {
		GSUser guser = userService.findByUserName(Mutation.getAuthenticatedUser().getUsername());
		return userProfileService.removeCharacter(characterType.longValue(), guser);
	}
}
