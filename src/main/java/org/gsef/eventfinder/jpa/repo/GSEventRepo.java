package org.gsef.eventfinder.jpa.repo;

import java.util.Optional;

import org.gsef.eventfinder.jpa.model.GSEvent;
import org.springframework.data.repository.CrudRepository;

public interface GSEventRepo extends CrudRepository<GSEvent, Long>{
	public Optional<GSEvent> findById(Long id);
}
