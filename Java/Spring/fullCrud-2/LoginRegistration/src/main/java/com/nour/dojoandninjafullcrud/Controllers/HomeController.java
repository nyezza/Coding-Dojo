package com.nour.dojoandninjafullcrud.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.nour.dojoandninjafullcrud.Models.LoginUser;
import com.nour.dojoandninjafullcrud.Models.UserModel;
import com.nour.dojoandninjafullcrud.Services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class HomeController {

	// Add once service is implemented:
    @Autowired
    private UserService userService;
    // === Display Route ===
    @GetMapping("/")
    public String index(Model model) {
        // Bind empty User and LoginUser objects to the JSP
        // to capture the form input
        model.addAttribute("newUser", new UserModel());
        model.addAttribute("newLogin", new LoginUser());
        return "log_reg.jsp";
    }
    // ==== Action Route for registration====
    @PostMapping("/register")
    public String register(@Valid @ModelAttribute("newUser") UserModel newUser, 
            BindingResult result, Model model, HttpSession session) {
        
    	// 1. Execute the Service register method
    	UserModel user = userService.register(newUser, result);
    	
        // extra validations and create a new user!
        
        if(result.hasErrors()) {
            // Be sure to send in the empty LoginUser before 
            // re-rendering the page.
        	 model.addAttribute("newLogin", new LoginUser());
             return "log_reg.jsp";
        }
        
        // No errors! Store their ID from the DB in session, and log in 
         
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
			UserModel loggedinUser = userService.findUser(id);
			model.addAttribute("user", loggedinUser);
			return "dashboard.jsp";
		}
	}
	
	//======Action route to login======
    @PostMapping("/login")
    public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, 
            BindingResult result, Model model, HttpSession session) {
        
    	// 1. Execute the Service login method
         UserModel user = userService.login(newLogin, result);
 
         if(result.hasErrors()) {
             // Be sure to send in the empty newUser before 
             // re-rendering the page.
             model.addAttribute("newUser", new UserModel());
             return "log_reg.jsp";
         }else {
        	// No errors! Store their ID from the DB in session, and log in 
         	session.setAttribute("userID", user.getId());
         	return "redirect:/home";
         }
    
    }
    
    @GetMapping("/logout")
	public String logout(HttpSession session) {
		session.setAttribute("userId", null); 
	    return "redirect:/";
	}
}
