package org.gsef.eventfinder.jpa.repo;

import java.util.List;

import org.gsef.eventfinder.jpa.model.GSUser;
import org.gsef.eventfinder.jpa.model.UserCharacter;
import org.springframework.data.repository.CrudRepository;

public interface GSUserCharacterRepo extends CrudRepository<UserCharacter, Long> {
	UserCharacter findByUserAndCharacterType(GSUser user, Integer characterType);
	List<UserCharacter> findAllByUser(GSUser user);
}