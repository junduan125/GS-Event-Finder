package org.gsef.eventfinder.jpa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "userid")
public class GSUser extends User {
	private static final long serialVersionUID = 1L;

	@Column
	private String uuid;
	@Column
	private int worldLevel;

	public static GSUser create(String username, String password, String uuid, int worldLevel) {
		return new GSUser(username, password, uuid, worldLevel);
	}

	public GSUser() {}

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
}
