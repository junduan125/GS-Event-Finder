package org.gsef.eventfinder.jpa.repo;

import org.gsef.eventfinder.jpa.model.GSEvent;
import org.gsef.eventfinder.jpa.model.GSEventUser;
import org.gsef.eventfinder.jpa.model.GSUser;
import org.springframework.data.repository.CrudRepository;

public interface GSEventUserRepo extends CrudRepository<GSEventUser, Long>{
	GSEventUser findByUserId(Long id);
	GSEventUser findByUserAndEvent(GSUser user, GSEvent event);
}
