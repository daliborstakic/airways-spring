package com.daliborstakic.airways.dtos;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class LoginUserDto {
	@NotEmpty(message = "Username cannot be empty!")
	@NotNull(message = "Username cannot be null!")
	@Size(min = 6, message = "Username must be at least 6 characters long!")
	private String username;

	@NotEmpty(message = "Password cannot be empty!")
	@NotNull(message = "Password cannot be null!")
	@Size(min = 6, message = "Password must be at least 6 characters long!")
	@Pattern(regexp = "^(?=.*[a-zA-Z])(?=.*\\d)(?=.*[^a-zA-Z0-9]).+$", message = "Password must contain at least one letter, one number, and one special character!")
	private String password;

	public LoginUserDto(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
