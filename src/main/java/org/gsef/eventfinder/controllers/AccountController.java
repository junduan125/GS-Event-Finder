package org.gsef.eventfinder.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AccountController {
	
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
}
