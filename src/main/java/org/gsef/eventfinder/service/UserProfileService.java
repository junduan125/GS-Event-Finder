package org.gsef.eventfinder.service;

import java.util.ArrayList;
import java.util.List;

import org.gsef.eventfinder.jpa.model.GSUser;
import org.gsef.eventfinder.jpa.model.UserCharacter;
import org.gsef.eventfinder.jpa.model.UserCharacter.CharacterType;
import org.gsef.eventfinder.jpa.repo.EndUserRepo;
import org.gsef.eventfinder.jpa.repo.GSUserCharacterRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserProfileService {
	@Autowired
	EndUserRepo endUsersRepo;

	@Autowired
	GSUserCharacterRepo userCharacterRepo;
	
	@Transactional
	public List<UserCharacter> ownedCharacters(GSUser user) {
		List<UserCharacter> characters = endUsersRepo.findById(user.getId()).get().getUserCharacters();
		characters.size();
		return characters;
	}

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
