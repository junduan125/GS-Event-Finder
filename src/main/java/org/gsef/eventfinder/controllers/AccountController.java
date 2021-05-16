package org.gsef.eventfinder.controllers;

import org.gsef.eventfinder.exception.UserExistsException;
import org.gsef.eventfinder.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	public String getAccountHomeView(@RequestParam(value = "error", required = false) String error, Model model) {
		if (error != null) model.addAttribute("errorMessage", "Invalid Username/Password");
		return "LoginPage";
	}

	@PostMapping("/register")
	public String getRegistration(
			@RequestParam(value = "username") String username,
			@RequestParam(value = "password") String password,
			@RequestParam(value = "uuid") String uuid,
			@RequestParam(value = "worldLevel") int worldLevel) {
		try {
			userService.registerNewGSUser(username, password, uuid, worldLevel);
		} catch (UserExistsException e) {
			e.printStackTrace();
		}
		return "WelcomePage";
	}
	
	@GetMapping("/loadTest")
	public String debugTestData() throws UserExistsException {
		userService.registerNewGSUser("test", "password", "000000", 1);
		return "WelcomePage";
	}
}
