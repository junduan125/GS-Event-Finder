package org.gsef.eventfinder.service;

import java.util.List;

import org.gsef.eventfinder.jpa.model.GSCharacter;
import org.gsef.eventfinder.jpa.model.GSUser;
import org.gsef.eventfinder.jpa.model.UserCharacter;
import org.gsef.eventfinder.jpa.repo.EndUserRepo;
import org.gsef.eventfinder.jpa.repo.GSCharacterRepo;
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
	@Autowired
	GSCharacterRepo gsCharacterRepo;
	
	public List<UserCharacter> ownedCharacters(GSUser user) {
		return userCharacterRepo.findAllByUser(user);
	}

	@Transactional
	public List<UserCharacter> addCharacter(Long characterType, int level, GSUser user) {
		UserCharacter character = userCharacterRepo.findByUserAndCharacterId(user, characterType);
		GSCharacter gsCharacter = gsCharacterRepo.findById(characterType).get();
		if (character == null) {
			character = new UserCharacter(gsCharacter, level);
			character.setUser(user);
			userCharacterRepo.save(character);
		}
		return userCharacterRepo.findAllByUser(user);
	}
	
	public UserCharacter editCharacter(Long characterType, int level, GSUser user) {
		UserCharacter character = userCharacterRepo.findByUserAndCharacterId(user, characterType);
		character.setLevel(level);
		return userCharacterRepo.save(character);
	}

	public List<UserCharacter> removeCharacter(Long characterType, GSUser user) {
		userCharacterRepo.delete(userCharacterRepo.findByUserAndCharacterId(user, characterType));
		return userCharacterRepo.findAllByUser(user);
	}
}
