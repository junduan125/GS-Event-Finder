package org.gsef.eventfinder.security;

import org.gsef.eventfinder.jpa.model.User;
import org.gsef.eventfinder.service.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomUserDetailService implements UserDetailsService {

	UserService userService;

	public CustomUserDetailService(UserService userService) {
		this.userService = userService;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userService.findByUserName(username);
		System.out.println("Load User " + user);
		if (user == null)
			throw new UsernameNotFoundException("Wrong username or password");
		return user;
	}
}
