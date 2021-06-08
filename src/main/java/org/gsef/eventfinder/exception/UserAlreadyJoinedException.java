package org.gsef.eventfinder.exception;

public class UserAlreadyJoinedException extends Exception {
	private static final long serialVersionUID = 1L;

	public UserAlreadyJoinedException(Long userId, Long eventId) {
		super("User " + userId + " already in the event " + eventId);
	}
}
