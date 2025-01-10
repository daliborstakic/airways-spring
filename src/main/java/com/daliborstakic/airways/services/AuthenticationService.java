package com.daliborstakic.airways.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.daliborstakic.airways.dtos.LoginUserDto;
import com.daliborstakic.airways.dtos.RegisterUserDto;
import com.daliborstakic.airways.model.User;
import com.daliborstakic.airways.repositories.UserRepository;

@Service
public class AuthenticationService {
	@Autowired
	private UserRepository userRepo;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private AuthenticationManager authenticationManager;

	public User signUp(RegisterUserDto userDto) {
		User user = new User();
		user.setUsername(userDto.getUsername());
		user.setPasswordHash(passwordEncoder.encode(userDto.getPassword()));
		user.setEmail(userDto.getEmail());

		return userRepo.save(user);
	}

	public User authenticate(LoginUserDto userDto) throws BadCredentialsException {
		authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(userDto.getUsername(), userDto.getPassword()));

		return userRepo.findByUsername(userDto.getUsername()).orElseThrow();
	}
}
