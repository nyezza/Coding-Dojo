package com.nour.dojoandninjafullcrud.Services;

import java.util.List;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.nour.dojoandninjafullcrud.Models.LoginUser;
import com.nour.dojoandninjafullcrud.Models.UserModel;
import com.nour.dojoandninjafullcrud.Repositories.UserRepository;



@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;


	 // returns all  users
	public List<UserModel> allUsers() {
	    return userRepository.findAll();
	}

	// creates a user
	public UserModel createUser(UserModel d) {
	    return userRepository.save(d);
	}

	// find on user by id
	public UserModel findUser(Long id) {
	    Optional<UserModel> optionalUser = userRepository.findById(id);
	    if(optionalUser.isPresent()) {
	        return optionalUser.get();
	    } else {
	        return null;
	    }
	}

	//Register
	public UserModel register(UserModel newUser, BindingResult result) {
		// check if a user exists ?
		Optional<UserModel> optionalUser = userRepository.findByEmail(newUser.getEmail());
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
	public UserModel login(LoginUser newLogin, BindingResult result) {
		Optional<UserModel> potentialUser = userRepository.findByEmail(newLogin.getEmail());
		if(!potentialUser.isPresent()) {
			result.rejectValue("email", "loginError", "Invalid credentials!");
		}else {
			UserModel user = potentialUser.get();
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
