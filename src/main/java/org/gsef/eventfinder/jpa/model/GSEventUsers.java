package org.gsef.eventfinder.jpa.model;

import java.util.List;

import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

public class GSEventUsers extends BaseEntity {

	@ManyToOne
	private GSEvent event;
	@OneToMany
	private List<GSUser> users;
	
	public GSEventUsers() {}

	public GSEvent getEvent() {
		return event;
	}

	public GSEventUsers setEvent(GSEvent event) {
		this.event = event;
		return this;
	}

	public List<GSUser> getUsers() {
		return users;
	}

	public GSEventUsers setUsers(List<GSUser> users) {
		this.users = users;
		return this;
	}
	
}
