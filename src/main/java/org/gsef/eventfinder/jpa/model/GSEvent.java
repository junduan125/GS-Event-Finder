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
	
	public enum GSEventType {UNKNOWN, SOCIAL, MINING, MOB_HUNTING };
	
	@Column
	private int eventType;
	@Column
	@Temporal(TemporalType.TIMESTAMP)
	private Date eventTime;
	@OneToMany
	private List<GSEventUser> eventUsers;
	
	public GSEvent() {}
	
	public GSEvent(Long eventTime, GSEventType eventType) {
		this.eventTime = new Date(eventTime);
		this.eventType = eventType.ordinal();
	}
	
	public GSEvent(Date eventTime, GSEventType eventType) {
		this.eventTime = eventTime;
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

	public List<GSEventUser> getEventUsers() {
		return eventUsers;
	}

	public void setEventUsers(List<GSEventUser> eventUsers) {
		this.eventUsers = eventUsers;
	}
}
