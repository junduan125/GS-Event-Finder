package org.gsef.eventfinder.jpa.repo;

import org.gsef.eventfinder.jpa.model.GSUser;
import org.springframework.data.repository.CrudRepository;

public interface EndUserRepo extends CrudRepository<GSUser, Long> {
	public GSUser findByUsername(String username);
}
