package org.gsef.eventfinder.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.gsef.eventfinder.exception.UserExceedEventMaximumException;
import org.gsef.eventfinder.graphql.query.GSEventEdgeConnection;
import org.gsef.eventfinder.graphql.query.model.SortOption;
import org.gsef.eventfinder.jpa.model.GSEvent;
import org.gsef.eventfinder.jpa.model.GSEvent.GSEventStatus;
import org.gsef.eventfinder.jpa.model.GSEvent.GSEventType;
import org.gsef.eventfinder.jpa.model.GSEventUser;
import org.gsef.eventfinder.jpa.model.GSUser;
import org.gsef.eventfinder.jpa.model.UserCharacter;
import org.gsef.eventfinder.jpa.model.UserCharacter.CharacterType;
import org.gsef.eventfinder.jpa.repo.GSEventRepo;
import org.gsef.eventfinder.jpa.repo.GSEventUserRepo;
import org.gsef.eventfinder.jpa.repo.GSUserCharacterRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EventService {

	private static int MAX_USER_PER_EVENT = 4;

	@Autowired
	GSEventRepo eventRepo;
	@Autowired
	GSEventUserRepo gsEventUserRepo;
	@Autowired
	GSUserCharacterRepo gsUserCharacterRepo;

	public GSEvent createEvent(Date eventTime, GSEventType eventType, Integer minWorldLevel) {
		return eventRepo.save(new GSEvent(eventTime, eventType, GSEventStatus.OPEN, minWorldLevel));
	}

	@Transactional
	public GSEvent joinEvent(Long id, GSUser user, CharacterType characterType) throws UserExceedEventMaximumException {
		GSEvent event = eventRepo.findById(id).get();
		if (event.getEventUsers().size() >= MAX_USER_PER_EVENT)
			throw new UserExceedEventMaximumException(id, event.getEventUsers().size(), MAX_USER_PER_EVENT);
		if (event.getEventUsers() == null) event.setEventUsers(new ArrayList<>());
		UserCharacter userCharacter = gsUserCharacterRepo.findByUserAndCharacterType(user, characterType.ordinal());
		event.getEventUsers().add(gsEventUserRepo.save(new GSEventUser(event, user, userCharacter)));
		if (event.getEventUsers().size() == MAX_USER_PER_EVENT)
			event.setFull(true);
		return eventRepo.save(event);
	}

	public Boolean leaveEvent(Long id, GSUser user) {
		GSEvent event = eventRepo.findById(id).get();
		GSEventUser gsEventUser = gsEventUserRepo.findByUserAndEvent(user, event);
		gsEventUserRepo.delete(gsEventUser);
		event.setFull(false);
		eventRepo.save(event);
		return false;
	}

	public List<GSEvent> listEvents() {
		return StreamSupport.stream(eventRepo.findAll().spliterator(), false).collect(Collectors.toList());
	}
	
	private Sort convertSortOptionToSort(List<SortOption> sortOptions) {
		Sort sorting;
		if (sortOptions == null || sortOptions.isEmpty()) {
			sorting = Sort.unsorted();
		} else {
			sorting = Sort.by(sortOptions.stream()
					.map(sortOption -> new Order(sortOption.getOrder(), sortOption.getField()))
					.collect(Collectors.toList()));
		}
		return sorting;
	}
	
	private List<Boolean> bothTrueFalse(Boolean both) {
		List<Boolean> inclusive = new ArrayList<>();
		if (both) {
			inclusive.add(true);
			inclusive.add(false);
		} else {
			inclusive.add(both);
		}
		return inclusive;
	}

	@Transactional
	public GSEventEdgeConnection listEvents(Integer size, Integer page, List<SortOption> sortOptions, List<GSEventStatus> status, List<GSEventType> eventType, Boolean includeFull) {
		Sort sorting = convertSortOptionToSort(sortOptions);
		if (status == null) status = Arrays.asList(GSEventStatus.values());
		if (eventType == null) eventType = Arrays.asList(GSEventType.values());
		List<Integer> statusSet = status.stream().map(GSEventStatus::ordinal).collect(Collectors.toList());
		List<Integer> eventTypeSet = eventType.stream().map(GSEventType::ordinal).collect(Collectors.toList());
		List<Boolean> isFullSet = bothTrueFalse(includeFull);

		Pageable pageable = PageRequest.of(page, size, sorting);
		Page<GSEvent> events = eventRepo.findAllByEventTypeInAndEventTypeInAndIsFullIn(eventTypeSet, statusSet, isFullSet, pageable);
		return new GSEventEdgeConnection(events);
	}
}
