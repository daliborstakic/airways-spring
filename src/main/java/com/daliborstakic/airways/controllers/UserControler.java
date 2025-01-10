package com.daliborstakic.airways.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.daliborstakic.airways.exceptions.UserNotFoundException;
import com.daliborstakic.airways.model.User;
import com.daliborstakic.airways.services.UserService;

@RestController
@RequestMapping("/users")
public class UserControler {
	@Autowired
	private UserService userService;

	@GetMapping("/all")
	public List<User> getAllUsers() {
		return userService.getAllUsers();
	}

	@GetMapping
	public User getUserByEmail(@RequestParam("email") String email) throws UserNotFoundException {
		return userService.getUserByEmail(email);
	}

	@GetMapping("/{id}")
	public User getUserById(@PathVariable Integer id) throws UserNotFoundException {
		return userService.getUserById(id);
	}
}
