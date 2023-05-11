package com.yezza.nadhir.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.yezza.nadhir.models.LoginUser;
import com.yezza.nadhir.models.User;
import com.yezza.nadhir.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class HomeController {
	
	@Autowired
	private UserService userServ;
	
	// display the home page
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("newUser",new User());
		model.addAttribute("newLogin",new LoginUser());
		return "log_reg.jsp";
	}
	
	// register route
	@PostMapping("/register")
	public String register(@Valid @ModelAttribute("newUser") User newUser,BindingResult result,Model model,HttpSession session){
		
		//Register Method
		User userTemp = userServ.register(newUser, result);
		
		// validation
		if(result.hasErrors()) {
			model.addAttribute("newLogin", new LoginUser());
			return "log_reg.jsp";
		}
		// if there are no error
		else {
			session.setAttribute("userID", newUser.getId());
			return "redirect:/home";
		}
		
	}
	
	 //display route to dashboard
		@GetMapping("/home")
		public String dashboardLog(HttpSession session, Model model) {
			//Gard route
			Long id = (Long) session.getAttribute("userID");
			if(id == null) {
				return "redirect:/";
			}else {
				// Pass the user Logedin to the dashboard file
				User loggedinUser = userServ.findUser(id);
				model.addAttribute("user", loggedinUser);
				return "dashboard.jsp";
			}
		}
		
		//======Action route to login======
	    @PostMapping("/login")
	    public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, 
	            BindingResult result, Model model, HttpSession session) {
	        
	    	// 1. Execute the Service login method
	         User user = userServ.login(newLogin, result);
	 
	         if(result.hasErrors()) {
	             // Be sure to send in the empty newUser before 
	             // re-rendering the page.
	             model.addAttribute("newUser", new User());
	             return "log_reg.jsp";
	         }else {
	        	// No errors! Store their ID from the DB in session, and log in 
	         	session.setAttribute("userID", user.getId());
	         	return "redirect:/home";
	         }
	    
	    }
	    // logout
	    @GetMapping("/logout")
	    public String logout(@ModelAttribute("user") User user,HttpSession session) {
	    	session.removeAttribute("user");
	    	return "redirect:/";
	    }
	}

