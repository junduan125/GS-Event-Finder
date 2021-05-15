package org.gsef.eventfinder.jpa.model;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
public class EndUser implements UserDetails {
	private static final long serialVersionUID = 1L;
	
	@Id
	private final long userid;
	
	private String username;
	private String password;
	
	@Transient
	Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();

	public EndUser(long userid, String username, String password) {
		authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
		this.userid = userid;
		this.username = username;
		this.password = password;
	}

	public long getUserid() {
		return userid;
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
	
	@Override
	public String toString() {
		return "{" + userid + " : " + username +"}";
	}
}
