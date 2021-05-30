package org.gsef.eventfinder.jpa.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "userid")
public class GSUser extends User {
	private static final long serialVersionUID = 1L;

	@Column
	private String uuid;
	@Column
	private int worldLevel;
	@OneToMany
	private List<UserCharacter> userCharacters;

	public static GSUser create(String username, String password, String uuid, int worldLevel) {
		return new GSUser(username, password, uuid, worldLevel);
	}

	public GSUser() {
	}

	protected GSUser(String username, String password, String uuid, int worldLevel) {
		super(username, password, Role.END_USER.ordinal());
		this.uuid = uuid;
		this.worldLevel = worldLevel;
	}

	public String getUUID() {
		return uuid;
	}

	public GSUser setUUID(String uuid) {
		this.uuid = uuid;
		return this;
	}

	public int getWorldLevel() {
		return worldLevel;
	}

	public GSUser setWorldLevel(int worldLevel) {
		this.worldLevel = worldLevel;
		return this;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public List<UserCharacter> getUserCharacters() {
		return userCharacters;
	}

	public void setUserCharacters(List<UserCharacter> userCharacters) {
		this.userCharacters = userCharacters;
	}
}
