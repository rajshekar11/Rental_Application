package com.rental.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class HomeController {

	@GetMapping("/home")
	public String welcome() {
		return "Welcome to Rental application";
	}
}
