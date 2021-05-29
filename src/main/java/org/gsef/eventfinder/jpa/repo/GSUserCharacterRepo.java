package org.gsef.eventfinder.jpa.repo;

import org.gsef.eventfinder.jpa.model.GSUser;
import org.gsef.eventfinder.jpa.model.UserCharacter;
import org.springframework.data.repository.CrudRepository;

public interface GSUserCharacterRepo extends CrudRepository<UserCharacter, Long> {
	UserCharacter findByUserAndCharacterType(GSUser user, Integer characterType);
}

