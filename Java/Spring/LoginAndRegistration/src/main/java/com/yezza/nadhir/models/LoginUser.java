package com.yezza.nadhir.models;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class LoginUser {
	
	// Member Variable
	@NotEmpty(message="Email is required!")
	@Email(message="Please a valid email!")
	private String email;
	
	@NotEmpty(message="password is required!")
	@Size(min=8,max=128,message="password size must be between 8 and 128")
	private String password;
	
	// Empty Constructor
	public LoginUser() {}

	// Getters and Setters
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
