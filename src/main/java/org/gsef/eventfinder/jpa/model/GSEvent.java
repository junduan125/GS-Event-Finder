package org.gsef.eventfinder.jpa.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.apache.tomcat.util.codec.binary.Base64;
import org.gsef.eventfinder.graphql.query.model.Node;

@Entity
public class GSEvent {
	
	public enum GSEventType {UNKNOWN, SOCIAL, MINING, MOB_HUNTING };
	public enum GSEventStatus { UNKNOWN, OPEN, CLOSED, DRAFT, FULL };
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	protected long id;
	@Column
	private int status;
	@Column
	private int eventType;
	@Column
	@Temporal(TemporalType.TIMESTAMP)
	private Date eventTime;
	@OneToMany
	private List<GSEventUser> eventUsers;
	
	public GSEvent() {}
	
	public GSEvent(Date eventTime, GSEventType eventType, GSEventStatus status) {
		this.eventTime = eventTime;
		this.eventType = eventType.ordinal();
		this.status = status.ordinal();
	}
	
	public GSEvent(Long eventTime, GSEventType eventType) {
		this(new Date(eventTime), eventType, GSEventStatus.OPEN);
	}
	
	public Long getId() {
		return id;
	}

	public GSEventStatus getStatus() {
		return GSEventStatus.values()[status];
	}

	public void setStatus(GSEventStatus status) {
		this.status = status.ordinal();
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
	
	public Integer getEventTimeSeconds() {
		return (int)(eventTime.getTime() / 1000);
	}

	public List<GSEventUser> getEventUsers() {
		return eventUsers;
	}

	public void setEventUsers(List<GSEventUser> eventUsers) {
		this.eventUsers = eventUsers;
	}
}
