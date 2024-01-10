package com.nadhir.yezza.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nadhir.yezza.models.Show;
import com.nadhir.yezza.models.User;
import com.nadhir.yezza.services.ShowServices;
import com.nadhir.yezza.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class ShowController {
	
	@Autowired
	private ShowServices showServ;
	@Autowired
	private UserService userServ;
	
	
	// Index page where i can see all shows
	@GetMapping("/shows")
	public String index(Model model,HttpSession session) {
		model.addAttribute("allShows", showServ.findAllShow());
		Long userId=(Long) session.getAttribute("userID");
		User currentUser = userServ.findOne(userId);
		model.addAttribute("user",currentUser);
		return "SHOW/index.jsp";		
	}
	
	// go to the create page
	@GetMapping("/shows/create")
	public String createShow(@ModelAttribute("show")Show show) {
		return "SHOW/createShow.jsp";
	}
	
	// save to the db
	@PostMapping("/shows")
	public String createShow(@Valid @ModelAttribute("show")Show show,
			BindingResult result,RedirectAttributes flash) {
		if(result.hasErrors()) {
			return"SHOW/createShow.jsp";
			
		}
		else {
			showServ.createShow(show);
			flash.addFlashAttribute("success","Awesome ! You just created a new show 🎉");
			return "redirect:/shows";
		}
	}
	
	// display one Show
	@GetMapping("/shows/{id}")
	public String displayOne(@PathVariable("id")Long id,Model model) {
		model.addAttribute("show", showServ.findShow(id));
		return"SHOW/oneShow.jsp";
	}
	
	// edit Show
		// 1 display edit page
	  @GetMapping("/shows/edit/{id}") public String editOne(@PathVariable("id")Long
	  id,Model model) { model.addAttribute("show", showServ.findShow(id));
	  return"SHOW/editShow.jsp"; 
	  }
	  	// 2 submit to changes to db
	  @PutMapping("/shows/{id}")
		public String updateShow(@Valid @ModelAttribute("show")Show show,
				BindingResult result,RedirectAttributes flash) {
			if(result.hasErrors()) {
				return"SHOW/editShow.jsp";
				
			}
			else {
				showServ.updateeShow(show);
				flash.addFlashAttribute("success","Awesome ! You just updated a show 🎉");
				return "redirect:/shows";
			}
		}
	  
	  @DeleteMapping("/shows/{id}")
	  public String deleteShow(@PathVariable("id")Long id) {
		  showServ.deletShow(id);
		  return "redirect:/shows";
	  }
	  
}
