package org.gsef.eventfinder.jpa.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class GSEvent extends BaseEntity {
	
	public enum EventType {UNKNOWN, SOCIAL, MINING, MOB_HUNTING };
	
	@Column
	private int eventType;
	@Column
	@Temporal(TemporalType.TIMESTAMP)
	private Date eventTime;
	@OneToMany
	private List<GSUser> eventUsers;
	
	public GSEvent() {}
	
	public GSEvent(long eventTime, EventType eventType) {
		this.eventTime = new Date(eventTime);
		this.eventType = eventType.ordinal();
	}

	public int getEventType() {
		return eventType;
	}

	public void setEventType(int eventType) {
		this.eventType = eventType;
	}

	public Date getEventTime() {
		return eventTime;
	}

	public void setEventTime(Date eventTime) {
		this.eventTime = eventTime;
	}
	
}
