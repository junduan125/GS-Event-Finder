package org.gsef.eventfinder.jpa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class GSCharacter {

	public enum ElementType {
		ANEMO, PRYO, HYDRO, ELECTRO, CRYO, DENDRO
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column
	private String name;
	@Column
	private int stars;
	@Column
	private int elementType;

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getStars() {
		return stars;
	}

	public void setStars(int stars) {
		this.stars = stars;
	}

	public ElementType getElementType() {
		return ElementType.values()[elementType];
	}

	public void setElementType(ElementType elementType) {
		this.elementType = elementType.ordinal();
	}
}
