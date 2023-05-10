package com.yezza.nadhir.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.yezza.nadhir.models.Travel;
import com.yezza.nadhir.services.TravelService;

import jakarta.validation.Valid;

@Controller
public class Travelcontroller {
	@Autowired
	private TravelService travelService;
	
	@GetMapping("/expenses")
	public String index(@ModelAttribute("onetravel")Travel travel,Model model) {
		List<Travel> allTravel = travelService.findAllTravel();
		model.addAttribute("onetravel", allTravel);
		return "expenses.jsp";
	}
	@PostMapping("/expenses")
	public String newExpense(@Valid @ModelAttribute("travel")Travel travel,BindingResult result,Model model) {
		/*if(result.hasErrors()) {
			List<Travel> allTravel = travelService.findAllTravel();
			model.addAttribute("travel", allTravel);
			return "expenses.jsp"; }
		else{*/
			travelService.createTravel(travel);
			return "redirect:/expenses";
		
	}
}
