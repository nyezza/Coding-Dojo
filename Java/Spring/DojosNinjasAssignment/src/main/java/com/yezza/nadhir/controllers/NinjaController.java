package com.yezza.nadhir.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.yezza.nadhir.models.Dojo;
import com.yezza.nadhir.models.Ninja;
import com.yezza.nadhir.services.DojoService;
import com.yezza.nadhir.services.NinjaService;

@Controller
public class NinjaController {
	@Autowired
	private NinjaService ninjaServ;
	
	@Autowired
	private DojoService dojoServ;
	
	@GetMapping("/")
	public String indexNinja(@ModelAttribute("newNinja")Ninja newNinja,Model Model) {
		List<Dojo> alldojo = dojoServ.allDojo();
		Model.addAttribute("allDojo", alldojo);
		return "Ninja/NewNinja.jsp";
	}
	
	@PostMapping("/")
	public String createNinja(@ModelAttribute("newNinja")Ninja newNinja) {
		ninjaServ.createNinja(newNinja);
		return "redirect:/";
	}
}
