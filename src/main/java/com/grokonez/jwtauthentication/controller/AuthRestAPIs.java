package com.grokonez.jwtauthentication.controller;

import java.util.*;

import javax.validation.Valid;

import com.grokonez.jwtauthentication.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import com.grokonez.jwtauthentication.message.request.LoginForm;
import com.grokonez.jwtauthentication.message.request.SignUpForm;
import com.grokonez.jwtauthentication.message.response.JwtResponse;
import com.grokonez.jwtauthentication.message.response.ResponseMessage;
import com.grokonez.jwtauthentication.model.Role;
import com.grokonez.jwtauthentication.model.RoleName;
import com.grokonez.jwtauthentication.model.User;
import com.grokonez.jwtauthentication.repository.RoleRepository;
import com.grokonez.jwtauthentication.repository.UserRepository;
import com.grokonez.jwtauthentication.security.jwt.JwtProvider;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthRestAPIs {

	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	UserRepository userRepository;

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	PasswordEncoder encoder;

	@Autowired
	JwtProvider jwtProvider;



	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginForm loginRequest) {

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);

		String jwt = jwtProvider.generateJwtToken(authentication);
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();

		return ResponseEntity.ok(new JwtResponse(jwt, userDetails.getUsername(), userDetails.getAuthorities()));
	}

	@org.springframework.web.bind.annotation.PostMapping("/signup")
	public org.springframework.http.ResponseEntity<?> registerUser(@javax.validation.Valid @org.springframework.web.bind.annotation.RequestBody SignUpForm signUpRequest) {
		if (userRepository.existsByUsername(signUpRequest.getUsername())) {
			return new org.springframework.http.ResponseEntity<>(new com.grokonez.jwtauthentication.message.response.ResponseMessage("Fail -> Username is already taken!"),
					org.springframework.http.HttpStatus.BAD_REQUEST);
		}

		if (userRepository.existsByEmail(signUpRequest.getEmail())) {
			return new org.springframework.http.ResponseEntity<>(new com.grokonez.jwtauthentication.message.response.ResponseMessage("Fail -> Email is already in use!"),
					org.springframework.http.HttpStatus.BAD_REQUEST);
		}

		// Creating user's account
		com.grokonez.jwtauthentication.model.User user = new com.grokonez.jwtauthentication.model.User(signUpRequest.getName(), signUpRequest.getUsername(), signUpRequest.getEmail(),
				encoder.encode(signUpRequest.getPassword()) ,  signUpRequest.getPhone(), signUpRequest.getCin()
				);

		java.util.Set<String> strRoles = signUpRequest.getRole();
		java.util.Set<com.grokonez.jwtauthentication.model.Role> roles = new java.util.HashSet<>();



		strRoles.forEach(role -> {
			switch (role) {
			case "hr":
				com.grokonez.jwtauthentication.model.Role hrRole = roleRepository.findByName(com.grokonez.jwtauthentication.model.RoleName.ROLE_HR)
						.orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
				roles.add(hrRole);

				break;
			case "encadrant":
				com.grokonez.jwtauthentication.model.Role encadrantRole = roleRepository.findByName(com.grokonez.jwtauthentication.model.RoleName. ROLE_ENCADRANT)
						.orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
				roles.add(encadrantRole);

				break;
			default:
				com.grokonez.jwtauthentication.model.Role userRole = roleRepository.findByName(com.grokonez.jwtauthentication.model.RoleName.ROLE_USER)
						.orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
				roles.add(userRole);
			}
		});

		user.setRoles(roles);
		com.grokonez.jwtauthentication.model.User save = userRepository.save(user);

		return new org.springframework.http.ResponseEntity<>(new com.grokonez.jwtauthentication.message.response.ResponseMessage("User registered successfully!"), org.springframework.http.HttpStatus.OK);
	}
}