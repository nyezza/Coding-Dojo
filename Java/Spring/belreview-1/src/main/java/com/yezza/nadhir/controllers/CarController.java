package com.yezza.nadhir.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.yezza.nadhir.services.CarService;
import com.yezza.nadhir.services.UserService;

@Controller
public class CarController {

	@Autowired
	private CarService carServ;
	@Autowired
	private UserService userSrv;
	
	@GetMapping("/car")
	public String showAllCar(Model model) {
		
			model.addAttribute("Allcar", carServ.findAllCars());
			return "dashboard.jsp";
		}
	}
	
	

