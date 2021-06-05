package org.gsef.eventfinder.graphql.query.model;

import org.springframework.data.domain.Sort.Direction;

public class SortOption {
	
	private String field;
	private Direction order;
	
	public String getField() {
		return field;
	}
	public void setField(String field) {
		this.field = field;
	}
	public Direction getOrder() {
		return order;
	}
	public void setOrder(Direction order) {
		this.order = order;
	}
}
