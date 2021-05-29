package org.gsef.eventfinder.service;

import java.util.ArrayList;

import org.gsef.eventfinder.jpa.model.GSUser;
import org.gsef.eventfinder.jpa.model.UserCharacter.CharacterType;
import org.gsef.eventfinder.jpa.repo.EndUserRepo;
import org.gsef.eventfinder.jpa.repo.GSUserCharacterRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserProfileService {
	@Autowired
	EndUserRepo endUsersRepo;

	@Autowired
	GSUserCharacterRepo userCharacterRepo;

	public GSUser addCharacter(CharacterType characterType, int level, GSUser user) {
		if (user.getUserCharacters() == null)
			user.setUserCharacters(new ArrayList<>());
		user.addCharacter(characterType, level);
		return endUsersRepo.save(user);
	}

	public GSUser removeCharacter(CharacterType characterType, GSUser user) {
		if (user.getUserCharacters() == null)
			user.setUserCharacters(new ArrayList<>());
		userCharacterRepo.delete(userCharacterRepo.findByUserAndCharacterType(user, characterType.ordinal()));
		return endUsersRepo.save(user);
	}
}
