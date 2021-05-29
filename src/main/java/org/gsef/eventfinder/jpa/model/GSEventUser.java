package org.gsef.eventfinder.jpa.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class GSEventUser extends BaseEntity {

	@OneToOne
	private GSEvent event;
	@OneToOne(cascade = CascadeType.DETACH)
	private GSUser user;
	
	public GSEventUser() {}
	
	public GSEventUser(GSEvent event, GSUser user) {
		this.event = event;
		this.user = user;
	}

	public GSEvent getEvent() {
		return event;
	}

	public GSEventUser setEvent(GSEvent event) {
		this.event = event;
		return this;
	}

	public GSUser getUser() {
		return user;
	}

	public void setUser(GSUser user) {
		this.user = user;
	}
	
}
