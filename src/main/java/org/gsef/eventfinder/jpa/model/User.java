package org.gsef.eventfinder.jpa.model;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Transient;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class User extends BaseEntity implements UserDetails {
	private static final long serialVersionUID = 1L;
	
	public enum Role { UNKNOWN, ADMIN, END_USER };

	@Column
	private String username;
	@Column
	private String password;
	@Column
	private int role;
	
	@Transient
	private Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
	
	public User() {}
	
	protected static User createEndUser(String username, String password) {
		return new User(username, password, Role.END_USER.ordinal());
	}

	protected User(String username, String password, int role) {
		this.username = username;
		this.password = password;
		this.role = role;
		switch(Role.values()[role]) {
		case END_USER: 
			authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
			break;
		default:
			break;
		}
	}

	@Override
	public Collection<GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
	
	public Role getRole() {
		return Role.values()[role];
	}
	
	@Override
	public String toString() {
		return "{" + id + " : " + username +"}";
	}
}
