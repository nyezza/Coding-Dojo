package com.yezza.nadhir.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;

@Controller
public class MainController {
	
	@RequestMapping("/omikuji")
	public String index() {
		return "index.jsp";
	}
	
	@RequestMapping("/omikuji/show")
	public String send(@RequestParam(value="num")int num,
						@RequestParam(value="city") String city,
						@RequestParam(value="person")String person,
						@RequestParam(value="hobby")String hobby,
						@RequestParam(value="living")String living,
						@RequestParam(value="someone")String someone,HttpSession session,Model model) {
		
		session.setAttribute("num", num);
		session.setAttribute("city", city);
		session.setAttribute("person", person);
		session.setAttribute("hobby", hobby);
		session.setAttribute("living", living);
		session.setAttribute("someone", someone);
		
		model.addAttribute("num", session.getAttribute("num"));
		model.addAttribute("city", session.getAttribute("city"));
		model.addAttribute("person", session.getAttribute("person"));
		model.addAttribute("hobby", session.getAttribute("hobby"));
		model.addAttribute("living", session.getAttribute("living"));
		model.addAttribute("someone", session.getAttribute("someone"));
		return "show.jsp";
		
	}
	
//	@RequestMapping("/omikuji/show")
//	public String show(Model model,HttpSession session) {
//		
//		return "show.jsp";
//	}
	

}
