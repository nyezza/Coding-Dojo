package com.yezza.nadhir.services;

import java.util.List;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.yezza.nadhir.models.LoginUser;
import com.yezza.nadhir.models.User;
import com.yezza.nadhir.repositories.UserRepository;

@Service
public class UserService {
	
	//Injection
	@Autowired
	private UserRepository userRepo;
	
	
	// return All users
	public List<User> findAllUser(){
		return userRepo.findAll();
	}
	
	// return user by id
	public User findUser(Long id) {
		Optional<User> oneUser= userRepo.findById(id);
		return (oneUser.isPresent())? oneUser.get(): null; 
	}
	
	//create User
	public User createUser(User user) {
		return userRepo.save(user);
	}
	
	//Register
	public User register(User newUser, BindingResult result) {
		// check user
		Optional<User> optionalUser = userRepo.findByEmail(newUser.getEmail());
		if(optionalUser.isPresent()) {
			result.rejectValue("password","registrationError","This Email is already Taken");
		}
		// confirm password matches
		if(!newUser.getPassword().equals(newUser.getConfirm())) {
			result.rejectValue("password", "registrationError", "password must match!");
		}
		if(result.hasErrors()) {
			return null;
		}else {
			//hash password 
			String hashedPassword=BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
			// add the hashed password
			newUser.setPassword(hashedPassword);
			// save user to the db
			return userRepo.save(newUser);
		}
	}
	
	//Login
	public User login(LoginUser newlogging, BindingResult result) {
		Optional<User> loggingUser = userRepo.findByEmail(newlogging.getEmail());
		if(!loggingUser.isPresent()) {
			result.rejectValue("email", "loginError", "Invalid Credentials!");
		}
		else {
			User userTemp = loggingUser.get();
			// decrypter
			if(!BCrypt.checkpw(newlogging.getPassword(),userTemp.getPassword() )) {
				result.rejectValue("password", "LoginError", "Invalid credential!");
			}
			if(result.hasErrors()) {
				return null;
			}else {
				return userTemp;
			}
		}
		return null;
		}
		
		
		
	}

