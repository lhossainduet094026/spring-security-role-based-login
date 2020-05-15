package com.luv2code.springsecurity.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
	@GetMapping("/showMyLoginPage")
	public String showLoginPage() {
		//return "plain-login";
		return "fancy-login";
	}
	//Add request mapping for access-denied url
	@GetMapping("/access-denied")
	public String showAccessDeniedPage() {
		//return "plain-login";
		return "access-denied";
	}
}
