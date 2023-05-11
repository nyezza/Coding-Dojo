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
	@Autowired
	private UserRepository userRepository;


	 // returns all  users
	public List<User> allUsers() {
	    return userRepository.findAll();
	}

	// creates a user
	public User createUser(User d) {
	    return userRepository.save(d);
	}

	// find on user by id
	public User findUser(Long id) {
	    Optional<User> optionalUser = userRepository.findById(id);
	    if(optionalUser.isPresent()) {
	        return optionalUser.get();
	    } else {
	        return null;
	    }
	}

	//Register
	public User register(User newUser, BindingResult result) {
		// check if a user exists ?
		Optional<User> optionalUser = userRepository.findByEmail(newUser.getEmail());
		if(optionalUser.isPresent()) {
			result.rejectValue("email", "registrationError", "This Email is already Taken!");
		}
		// Check if passwords matches
		if(!newUser.getPassword().equals(newUser.getConfirm())) {
			result.rejectValue("password", "registrationError", "Passwords must match !");
		} 
		if(result.hasErrors()) {
			return null;
		}else {
			// hash the password
			String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
			// intercept the user object to store the hashed password instead of plain-text
			newUser.setPassword(hashed);
			// save user to the DB
			return userRepository.save(newUser);
		}	
	}

	//login
	public User login(LoginUser newLogin, BindingResult result) {
		Optional<User> potentialUser = userRepository.findByEmail(newLogin.getEmail());
		if(!potentialUser.isPresent()) {
			result.rejectValue("email", "loginError", "Invalid credentials!");
		}else {
			User user = potentialUser.get();
			// BCRYPT check password
			if(!BCrypt.checkpw(newLogin.getPassword(), user.getPassword())) {
				result.rejectValue("password","loginError", "Invalid credentials!" );
			}
			if(result.hasErrors()) {
				return null;
			}else {
				return user;
			}
			
		}
	    return null;
	   
	}

}
