package com.nadhir.yezza.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BooksApi {

	
	@RequestMapping("/home")
	public String home() {
		return "home.jsp";
	}
}
