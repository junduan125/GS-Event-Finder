package org.gsef.eventfinder.jpa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class UserCharacter {
	
	public enum CharacterType {UNKNOWN, Albedo, Amber, Barbara, Beidou, Bennett, Chongyun};

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	protected long id;
	@Column
	private int level;
	@Column
	private int characterType;
	@ManyToOne
	private GSUser user;
	
	public UserCharacter() {}
	
	public UserCharacter(CharacterType characterType, int level) {
		this.characterType = characterType.ordinal();
		this.level = level;
	}
	
	public Long getId() {
		return id;
	}

	public void setCharacterType(int characterType) {
		this.characterType = characterType;
	}

	public int getLevel() {
		return level;
	}

	public UserCharacter setLevel(int level) {
		this.level = level;
		return this;
	}

	public CharacterType getCharacterType() {
		return CharacterType.values()[characterType];
	}
	
	public Integer getCharacterTypeID() {
		return characterType;
	}
	
	public void setCharacterTypeID(Integer characterType) {
		this.characterType = characterType;
	}

	public UserCharacter setCharacterType(CharacterType characterType) {
		this.characterType = characterType.ordinal();
		return this;
	}

	public GSUser getUser() {
		return user;
	}

	public void setUser(GSUser user) {
		this.user = user;
	}
	
	
	
}
