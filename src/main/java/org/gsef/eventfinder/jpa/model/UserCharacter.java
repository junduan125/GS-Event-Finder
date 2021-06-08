package org.gsef.eventfinder.jpa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class UserCharacter {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	protected long id;
	@Column
	private int level;
	@OneToOne(fetch = FetchType.EAGER)
	private GSCharacter character;
	@ManyToOne
	private GSUser user;
	
	public UserCharacter() {}
	
	public UserCharacter(GSCharacter character, int level) {
		this.character = character;
		this.level = level;
	}
	
	public Long getId() {
		return id;
	}

	public int getLevel() {
		return level;
	}

	public UserCharacter setLevel(int level) {
		this.level = level;
		return this;
	}

	public GSUser getUser() {
		return user;
	}

	public void setUser(GSUser user) {
		this.user = user;
	}

	public GSCharacter getCharacter() {
		return character;
	}

	public void setCharacter(GSCharacter character) {
		this.character = character;
	}
	
	public Integer getCharacterID() {
		return (int) character.getId();
	}
}
