package com.nadhir.yezza.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainControllers {
	
	
	
	@RequestMapping("/")
	public String index(Model model) {
		String name= "Nadhir Yezza";
		String itemName="Copper Wire";
		double price=5.25;
		String description="Metal strips. Also an illustration of naniseconds";
		String vendor="Little Things Corner Store";
		
		model.addAttribute("name",name);
		model.addAttribute("itemName",itemName);
		model.addAttribute("price",price);
		model.addAttribute("description",description);
		model.addAttribute("vendor",vendor);
		
		return "index.jsp";
	}
}
