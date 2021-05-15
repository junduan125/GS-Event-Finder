package org.gsef.eventfinder.security;

import java.util.ArrayList;
import java.util.List;

import org.gsef.eventfinder.jpa.model.EndUser;
import org.gsef.eventfinder.jpa.service.EndUsers;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

public class CustomUserDetailService implements UserDetailsService {

	PasswordEncoder encoder;
	EndUsers endUsersRepo;

	public CustomUserDetailService(EndUsers endUsersRepo) {
		encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
		this.endUsersRepo = endUsersRepo;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		List<EndUser> users = new ArrayList<>();
		endUsersRepo.findAll().forEach(users::add);
		System.out.println(users);
		EndUser user = endUsersRepo.findByUsername(username);
		System.out.println("Load User " + user);
		if (user == null)
			throw new UsernameNotFoundException("Wrong username or password");
		return new EndUser(user.getUserid(), user.getUsername(), user.getPassword());
	}
}
