package org.gsef.eventfinder.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.gsef.eventfinder.exception.UserExceedEventMaximumException;
import org.gsef.eventfinder.graphql.query.model.SortOption;
import org.gsef.eventfinder.jpa.model.GSEvent;
import org.gsef.eventfinder.jpa.model.GSEvent.GSEventStatus;
import org.gsef.eventfinder.jpa.model.GSEvent.GSEventType;
import org.gsef.eventfinder.jpa.model.GSEventUser;
import org.gsef.eventfinder.jpa.model.GSUser;
import org.gsef.eventfinder.jpa.repo.GSEventRepo;
import org.gsef.eventfinder.jpa.repo.GSEventUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Service;

@Service
public class EventService {

	private static int MAX_USER_PER_EVENT = 4;

	@Autowired
	GSEventRepo eventRepo;

	@Autowired
	GSEventUserRepo gsEventUserRepo;

	public GSEvent createEvent(Date eventTime, GSEventType eventType) {
		return eventRepo.save(new GSEvent(eventTime, eventType, GSEventStatus.OPEN));
	}

	public GSEvent joinEvent(Long id, GSUser user) throws UserExceedEventMaximumException {
		GSEvent event = eventRepo.findById(id).get();
		if (event.getEventUsers().size() >= MAX_USER_PER_EVENT)
			throw new UserExceedEventMaximumException(id, event.getEventUsers().size(), MAX_USER_PER_EVENT);
		if (event.getEventUsers() == null)
			event.setEventUsers(new ArrayList<>());
		event.getEventUsers().add(new GSEventUser(event, user));
		return eventRepo.save(event);
	}

	public Boolean leaveEvent(Long id, GSUser user) {
		GSEvent event = eventRepo.findById(id).get();
		GSEventUser gsEventUser = gsEventUserRepo.findByUserAndEvent(user, event);
		gsEventUserRepo.delete(gsEventUser);
		return false;
	}

	public List<GSEvent> listEvents() {
		return StreamSupport.stream(eventRepo.findAll().spliterator(), false).collect(Collectors.toList());
	}

	public Page<GSEvent> listEvents(Integer size, Integer page, List<SortOption> sortOptions, GSEventStatus status, GSEventType eventType) {
		Sort sorting;
		if (sortOptions == null || sortOptions.isEmpty()) {
			sorting = Sort.unsorted();
		} else {
			sorting = Sort.by(sortOptions.stream()
					.map(sortOption -> new Order(sortOption.getOrder(), sortOption.getField()))
					.collect(Collectors.toList()));
		}

		Pageable pageable = PageRequest.of(page, size, sorting);
		if (status == null && eventType == null)
			return eventRepo.findAll(pageable);
		else if (status == null)
			return eventRepo.findAllByEventType(eventType.ordinal(), pageable);
		else if (eventType == null)
			return eventRepo.findAllByStatus(status.ordinal(), pageable);
		else 
			return eventRepo.findAllByEventTypeAndStatus(eventType.ordinal(), status.ordinal(), pageable);
	}
}
