package org.gsef.eventfinder.jpa.repo;

import java.util.List;

import org.gsef.eventfinder.jpa.model.GSEvent;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface GSEventRepo extends PagingAndSortingRepository<GSEvent, Long>{
	public Page<GSEvent> findAllByEventTypeInAndEventTypeInAndIsFullIn(
			List<Integer> eventType,
			List<Integer> status,
			List<Boolean> isFull,
			Pageable pageable);
}
