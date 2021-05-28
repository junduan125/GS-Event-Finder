package org.gsef.eventfinder.service;

import org.gsef.eventfinder.exception.UserExistsException;
import org.gsef.eventfinder.jpa.model.GSUser;
import org.gsef.eventfinder.jpa.model.User;
import org.gsef.eventfinder.jpa.repo.EndUserRepo;
import org.gsef.eventfinder.model.NewGSUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	@Autowired
	EndUserRepo endUsersRepo;

	public GSUser findByUserName(String username) {
		return endUsersRepo.findByUsername(username);
	}

	public GSUser registerNewGSUser(NewGSUser newUser) throws UserExistsException {
		User user = endUsersRepo.findByUsername(newUser.getUsername());
		if (user != null)
			throw new UserExistsException(newUser.getUsername());
		PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
		return endUsersRepo.save(GSUser.create(newUser.getUsername(), encoder.encode(newUser.getPassword()),
				newUser.getUuid(), newUser.getWorldLevel()));
	}
}
