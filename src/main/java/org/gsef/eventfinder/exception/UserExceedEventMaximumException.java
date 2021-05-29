package org.gsef.eventfinder.exception;

public class UserExceedEventMaximumException extends Exception {
	private static final long serialVersionUID = 1L;

	public UserExceedEventMaximumException(Long id, int size, int max) {
		super("Attempting to join event ("+ id +") with " + size + " users, max allowed is " + max);
	}
}