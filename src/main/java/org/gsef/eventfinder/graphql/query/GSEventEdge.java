package org.gsef.eventfinder.graphql.query;

import org.gsef.eventfinder.graphql.query.model.GSEvent;

import graphql.relay.ConnectionCursor;

public class GSEventEdge {
	private String cursor;
	private GSEvent node;
	
	public static GSEventEdge create(ConnectionCursor cursor, org.gsef.eventfinder.jpa.model.GSEvent gsEvent) {
		return new GSEventEdge(cursor.getValue(), new GSEvent(gsEvent));
	}
	
	public GSEventEdge(String cursor, GSEvent gsEvent) {
		this.cursor = cursor;
		this.node = gsEvent;
	}

	public String getCursor() {
		return cursor;
	}

	public void setCursor(String cursor) {
		this.cursor = cursor;
	}

	public GSEvent getNode() {
		return node;
	}

	public void setNode(GSEvent node) {
		this.node = node;
	}
}
