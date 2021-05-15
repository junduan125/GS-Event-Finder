package org.gsef.eventfinder.jpa.repo;

import org.gsef.eventfinder.jpa.model.User;
import org.springframework.data.repository.CrudRepository;

public interface EndUserRepo extends CrudRepository<User, Long> {
	public User findByUsername(String username);
}
