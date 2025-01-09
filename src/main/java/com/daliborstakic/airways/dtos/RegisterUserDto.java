package com.daliborstakic.airways.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class RegisterUserDto {
	@NotNull(message = "Username cannot be null!")
	@NotEmpty(message = "Username cannot be empty!")
	@Size(min = 6, message = "Username must be at least 6 characters long!")
	private String username;

	@NotNull(message = "Password cannot be null!")
	@NotEmpty(message = "Password cannot be empty!")
	@Size(min = 6, message = "Password must be at least 6 characters long!")
	@Pattern(regexp = "^(?=.*[a-zA-Z])(?=.*\\d)(?=.*[^a-zA-Z0-9]).+$", message = "Password must contain at least one letter, one number, and one special character!")
	private String password;

	@NotNull(message = "Email cannot be null!")
	@NotEmpty(message = "Email cannot be empty!")
	@Email(message = "Email must be in a valid email format!")
	private String email;

	public RegisterUserDto(String username, String password, String email) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
