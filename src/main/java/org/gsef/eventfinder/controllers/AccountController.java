package org.gsef.eventfinder.controllers;

import org.gsef.eventfinder.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AccountController {
	
	@Autowired
	UserService userService;

	@GetMapping("/")
	public String getHomeView() {
		return "WelcomePage";
	}

	@GetMapping("/account")
	public String getAccountView() {
		return "";
	}

	@GetMapping("/login")
	public String getAccountHomeView() {
		return "LoginPage";
	}

	@GetMapping("/register")
	public String getRegistration(
			@Param(value = "username") String username,
			@Param(value = "password") String password) {
		userService.registerNewGSUser(username, password);
		return "WelcomePage";
	}
	
	@GetMapping("/loadTest")
	public String debugTestData() {
		userService.registerNewGSUser("test", "{noop}password");
		return "WelcomePage";
	}
}
