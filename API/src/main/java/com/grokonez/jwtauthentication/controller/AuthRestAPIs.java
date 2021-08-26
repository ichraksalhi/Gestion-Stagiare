package com.grokonez.jwtauthentication.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.grokonez.jwtauthentication.message.request.LoginForm;
import com.grokonez.jwtauthentication.message.request.SignUpForm;
import com.grokonez.jwtauthentication.message.response.JwtResponse;
import com.grokonez.jwtauthentication.message.response.ResponseMessage;
import com.grokonez.jwtauthentication.model.RoleName;
import com.grokonez.jwtauthentication.repository.RoleRepository;
import com.grokonez.jwtauthentication.repository.UserRepository;
import com.grokonez.jwtauthentication.security.jwt.JwtProvider;
import com.grokonez.jwtauthentication.model.Role ;
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

		return ResponseEntity.ok(new JwtResponse(jwt));
	}

	@org.springframework.web.bind.annotation.PostMapping("/signup")
	public org.springframework.http.ResponseEntity<?> registerUser(@javax.validation.Valid @org.springframework.web.bind.annotation.RequestBody SignUpForm signUpRequest) {
		if (userRepository.existsByUsername(signUpRequest.getUsername())) {
			return new ResponseEntity<>(new ResponseMessage("Fail -> Username is already taken!"),
					HttpStatus.BAD_REQUEST);
		}

		if (userRepository.existsByEmail(signUpRequest.getEmail())) {
			return new ResponseEntity<>(new JwtResponse("Fail -> Email is already in use!"),
					HttpStatus.BAD_REQUEST);
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
					Role hrRole = roleRepository.findByName(RoleName.ROLE_HR).orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
					roles.add(hrRole);

					break;
				case "encadrant":
					Role encadrantRole = roleRepository.findByName(RoleName.ROLE_ENCADRANT).orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
					roles.add(encadrantRole);

					break;
				default:
					Role userRole = roleRepository.findByName(RoleName.ROLE_USER)
							.orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
					roles.add(userRole);
			}
		});

		user.setRoles(roles);
		userRepository.save(user);

		return new org.springframework.http.ResponseEntity<>(new com.grokonez.jwtauthentication.message.response.ResponseMessage("User registered successfully!"), org.springframework.http.HttpStatus.OK);
	}
}