package com.yezza.nadhir.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.yezza.nadhir.models.Dojo;
import com.yezza.nadhir.models.Ninja;
import com.yezza.nadhir.services.DojoService;
import com.yezza.nadhir.services.NinjaService;

@Controller
public class DojoController {

	@Autowired
	private DojoService dojoServ;
	@Autowired
	private NinjaService ninjaServ;
	
	
	@GetMapping("/dojo")
	public String index() {
		return "redirect:/dojos/new";
	}
	
	@GetMapping("/dojos/new")
	public String newDojo(@ModelAttribute("newDojo")Dojo newDojo) {
		return "Dojo/NewDojo.jsp";
	}
	@PostMapping("/dojo")
	public String createDojo(@ModelAttribute("newDojo")Dojo newDojo,BindingResult result) {
		dojoServ.createOneDojo(newDojo);
		return "redirect:/dojo";
	}
	
	@GetMapping("/dojos/{id}")
	public String showNinjadojo(@PathVariable("id")Long id,Model model) {
		Dojo newDojo = dojoServ.oneDojo(id);
		Ninja newNinja = ninjaServ.findNinjaById(newDojo.getId());
		model.addAttribute("newNinja", newNinja);
		model.addAttribute("newDojo",newDojo);
		return "Ninja/AllNinja.jsp";
	}
}
