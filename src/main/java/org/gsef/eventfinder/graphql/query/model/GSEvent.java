package org.gsef.eventfinder.graphql.query.model;

import java.util.ArrayList;
import java.util.List;

import org.apache.tomcat.util.codec.binary.Base64;
import org.gsef.eventfinder.jpa.model.GSUser;

public class GSEvent implements Node {

	private org.gsef.eventfinder.jpa.model.GSEvent gsEvent;

	public GSEvent(org.gsef.eventfinder.jpa.model.GSEvent gsEvent) {
		this.gsEvent = gsEvent;
	}

	@Override
	public String getId() {
		return Base64.encodeBase64URLSafeString(Long.toString(gsEvent.getId()).getBytes());
	}

	public Integer getEventType() {
		return gsEvent.getEventType();
	}

	public Integer getEventTime() {
		return gsEvent.getEventTimeSeconds();
	}
	
	public List<GSUser> getJoinedUsers() {
		return new ArrayList<>();
	}
}
