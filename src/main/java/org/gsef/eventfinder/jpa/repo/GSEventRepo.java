package org.gsef.eventfinder.jpa.repo;

import org.gsef.eventfinder.jpa.model.GSEvent;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface GSEventRepo extends PagingAndSortingRepository<GSEvent, Long>{
	public Page<GSEvent> findAllByStatus(Integer status, Pageable pageable);
	public Page<GSEvent> findAllByEventType(Integer eventType, Pageable pageable);
	public Page<GSEvent> findAllByEventTypeAndStatus(Integer eventType, Integer status, Pageable pageable);
}
