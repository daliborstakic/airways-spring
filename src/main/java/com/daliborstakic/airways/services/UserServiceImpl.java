package com.daliborstakic.airways.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daliborstakic.airways.exceptions.UserNotFoundException;
import com.daliborstakic.airways.model.User;
import com.daliborstakic.airways.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepo;

	@Override
	public List<User> getAllUsers() {
		return userRepo.findAll();
	}

	@Override
	public User getUserByEmail(String email) throws UserNotFoundException {
		Optional<User> user = userRepo.findByEmail(email);

		if (user.isEmpty())
			throw new UserNotFoundException("The user with the address " + email + " has not been found.");

		return user.get();
	}

	@Override
	public User getUserById(Integer id) throws UserNotFoundException {
		Optional<User> user = userRepo.findById(id);

		if (user.isEmpty())
			throw new UserNotFoundException("The user with the id " + id + " has not been found.");

		return user.get();
	}
}
