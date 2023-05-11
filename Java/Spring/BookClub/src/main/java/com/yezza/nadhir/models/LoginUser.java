package com.yezza.nadhir.models;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class LoginUser {
	
	@NotEmpty(message="Email is required!")
	@Email(message="Please enter a valid email")
	private String email;
	
	@NotEmpty(message="Password is required!")
	@Size(min=2,max=30,message="password must be between 2 and 30 characters")
	private String password;
	
	//Empty constructor
	public LoginUser() {}
	
	// Getters & Setters
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
