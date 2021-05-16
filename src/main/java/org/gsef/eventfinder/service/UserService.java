package org.gsef.eventfinder.service;

import org.gsef.eventfinder.exception.UserExistsException;
import org.gsef.eventfinder.jpa.model.GSUser;
import org.gsef.eventfinder.jpa.model.User;
import org.gsef.eventfinder.jpa.repo.EndUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	
	@Autowired
	EndUserRepo endUsersRepo;
	
	public User findByUserName(String username) {
		return endUsersRepo.findByUsername(username);
	}
	
	public User registerNewGSUser(String username, String password) throws UserExistsException {
		User user = endUsersRepo.findByUsername(username);
		if (user == null) throw new UserExistsException(username);
		return endUsersRepo.save(GSUser.create(username, password, "000000", 0));
	}
}
