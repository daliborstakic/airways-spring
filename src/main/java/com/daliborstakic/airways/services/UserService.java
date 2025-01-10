package com.daliborstakic.airways.services;

import java.util.List;

import com.daliborstakic.airways.exceptions.UserNotFoundException;
import com.daliborstakic.airways.model.User;

public interface UserService {
	public List<User> getAllUsers();

	public User getUserByEmail(String email) throws UserNotFoundException;

	public User getUserById(Integer id) throws UserNotFoundException;
}
