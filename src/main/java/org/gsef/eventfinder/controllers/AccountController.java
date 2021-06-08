package org.gsef.eventfinder.controllers;

import org.gsef.eventfinder.exception.UserExistsException;
import org.gsef.eventfinder.jpa.model.GSUser;
import org.gsef.eventfinder.model.NewGSUser;
import org.gsef.eventfinder.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {
	
	@Autowired
	UserService userService;
	
	@ResponseBody
	@GetMapping(value = "/profile", produces = MediaType.APPLICATION_JSON_VALUE)
	public NewGSUser getProfile() {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (!(principal instanceof UserDetails) || principal == null) return new NewGSUser();
		GSUser guser = userService.findByUserName(((UserDetails)principal).getUsername());
		return new NewGSUser(guser.getUsername(), guser.getUUID(), guser.getWorldLevel());
	}
	
	@PostMapping(path="/register", consumes = "application/json", produces = "application/json")
	public String getRegistration(@RequestBody NewGSUser registeredUser) {
		try {
			userService.registerNewGSUser(registeredUser);
		} catch (UserExistsException e) {
			e.printStackTrace();
		}
		return "";
	}
}
