package com.daliborstakic.airways.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.daliborstakic.airways.dtos.LoginResponse;
import com.daliborstakic.airways.dtos.LoginUserDto;
import com.daliborstakic.airways.model.User;
import com.daliborstakic.airways.services.AuthenticationService;
import com.daliborstakic.airways.services.JWTService;
import com.daliborstakic.airways.services.RegisterUserDto;

@RequestMapping("/auth")
@RestController
public class AuthController {
	@Autowired
	private AuthenticationService authService;

	@Autowired
	private JWTService jwtService;

	@PostMapping("/register")
	public ResponseEntity<User> register(@RequestBody RegisterUserDto registerUser) {
		User registeredUser = authService.signUp(registerUser);

		System.out.println(registeredUser.getCreatedAt());
		return ResponseEntity.ok(registeredUser);
	}

	@PostMapping("/login")
	public ResponseEntity<LoginResponse> authenticate(@RequestBody LoginUserDto loginUser) {
		User authenticatedUser = authService.authenticate(loginUser);
		String jwtToken = jwtService.generateToken(authenticatedUser);

		LoginResponse loginResponse = new LoginResponse();
		loginResponse.setToken(jwtToken);
		loginResponse.setExpiresIn(jwtService.getExpirationTime());

		return ResponseEntity.ok(loginResponse);
	}

}
