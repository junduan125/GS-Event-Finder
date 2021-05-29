package org.gsef.eventfinder.exception;

public class EventNotFoundException  extends Exception {
	private static final long serialVersionUID = 1L;

	public EventNotFoundException(Long id) {
		super("Event with id " + id + " not found");
	}
}
