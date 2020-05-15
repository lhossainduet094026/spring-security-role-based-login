package com.luv2code.springsecurity.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {
	@GetMapping("/")
	public String showHome() {
		return "home";
	}

	// Add leader controller
	@GetMapping("/leaders")
	public String showLeaderPage() {
		return "leader";
	}

	@GetMapping("/systems")
	public String showSystemPage() {
		return "system";
	}
}
