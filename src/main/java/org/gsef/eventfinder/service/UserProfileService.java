package org.gsef.eventfinder.service;

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

	@Transactional
	public List<UserCharacter> addCharacter(CharacterType characterType, int level, GSUser user) {
		UserCharacter character = userCharacterRepo.findByUserAndCharacterType(user, characterType.ordinal());
		if (character == null) {
			character = new UserCharacter(characterType, level);
			character.setUser(user);
			userCharacterRepo.save(character);
		}
		System.out.println("userid " + user.getId());
		return userCharacterRepo.findAllByUser(user);
	}
	
	public UserCharacter editCharacter(CharacterType characterType, int level, GSUser user) {
		UserCharacter character = userCharacterRepo.findByUserAndCharacterType(user, characterType.ordinal());
		character.setLevel(level);
		return userCharacterRepo.save(character);
	}

	public List<UserCharacter> removeCharacter(CharacterType characterType, GSUser user) {
		userCharacterRepo.delete(userCharacterRepo.findByUserAndCharacterType(user, characterType.ordinal()));
		List<UserCharacter> characterList = endUsersRepo.findById(user.getId()).get().getUserCharacters();
		characterList.size();
		return characterList;
	}
}
