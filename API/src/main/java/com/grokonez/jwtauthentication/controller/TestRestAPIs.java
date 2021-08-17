package com.grokonez.jwtauthentication.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class TestRestAPIs {
	
	@GetMapping("/api/test/user")
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public String userAccess() {
		return ">>> User Contents!";
	}

	@GetMapping("/api/test/ENCADRANT")
	@PreAuthorize("hasRole('ENCADRANT') or hasRole('HR')")
	public String projectManagementAccess() {
		return ">>> Project Management Board";
	}
	
	@GetMapping("/api/test/HR")
	@PreAuthorize("hasRole('HR')")
	public String adminAccess() {
		return ">>> HR Contents";
	}
}