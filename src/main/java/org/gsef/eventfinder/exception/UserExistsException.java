package org.gsef.eventfinder.exception;

public class UserExistsException extends Exception {
	private static final long serialVersionUID = 1L;

	public UserExistsException(String username) {
		super("User with username " + username + " already exists");
	}
}
