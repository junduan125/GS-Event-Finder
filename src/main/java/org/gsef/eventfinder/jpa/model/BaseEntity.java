package org.gsef.eventfinder.jpa.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;

@Entity
@Inheritance
public abstract class BaseEntity {
	
	@Id
	protected long id;
	
	public Long getId() {
		return id;
	}
	
	@Override
	public boolean equals(Object o) {
		BaseEntity baseEntity = (BaseEntity) o;
		return this.getId().equals(baseEntity.getId());
	}
}
