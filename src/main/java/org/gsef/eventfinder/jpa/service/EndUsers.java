package org.gsef.eventfinder.jpa.service;

import org.gsef.eventfinder.jpa.model.EndUser;
import org.springframework.data.repository.CrudRepository;

public interface EndUsers extends CrudRepository<EndUser, Long> {
	public EndUser findByUsername(String username);
}
