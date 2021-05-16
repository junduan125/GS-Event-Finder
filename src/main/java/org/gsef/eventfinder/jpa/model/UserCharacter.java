package org.gsef.eventfinder.jpa.model;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class UserCharacter extends BaseEntity {
	
	public enum CharacterType {UNKNOWN, TRAVELLER };

	@Column
	private int level;
	@Column
	private int characterType;
	
	public UserCharacter() {}
	
	public UserCharacter(CharacterType characterType, int level) {
		this.characterType = characterType.ordinal();
		this.level = level;
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

	public UserCharacter setCharacterType(CharacterType characterType) {
		this.characterType = characterType.ordinal();
		return this;
	}
}
