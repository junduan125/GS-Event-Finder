package org.gsef.eventfinder.controllers;

import org.gsef.eventfinder.exception.UserExistsException;
import org.gsef.eventfinder.model.NewGSUser;
import org.gsef.eventfinder.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AccountController {
	
	@Autowired
	UserService userService;

	//@GetMapping("/login")
	public String getAccountHomeView(@RequestParam(value = "error", required = false) String error, Model model) {
		if (error != null) model.addAttribute("errorMessage", "Invalid Username/Password");
		return "LoginPage";
	}

	
	@PostMapping(path="/register", consumes = "application/json", produces = "application/json")
	public String getRegistration(@RequestBody NewGSUser registeredUser) {
		try {
			userService.registerNewGSUser(registeredUser);
		} catch (UserExistsException e) {
			e.printStackTrace();
		}
		return "WelcomePage";
	}
}
