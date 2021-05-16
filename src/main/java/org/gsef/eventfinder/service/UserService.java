package org.gsef.eventfinder.service;

import org.gsef.eventfinder.exception.UserExistsException;
import org.gsef.eventfinder.jpa.model.GSUser;
import org.gsef.eventfinder.jpa.model.User;
import org.gsef.eventfinder.jpa.repo.EndUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	@Autowired
	EndUserRepo endUsersRepo;

	public User findByUserName(String username) {
		return endUsersRepo.findByUsername(username);
	}

	public GSUser registerNewGSUser(String username, String password, String uuid, int worldLevel)
			throws UserExistsException {
		User user = endUsersRepo.findByUsername(username);
		if (user != null)
			throw new UserExistsException(username);
		PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
		return endUsersRepo.save(GSUser.create(username, encoder.encode(password), uuid, worldLevel));
	}
}
