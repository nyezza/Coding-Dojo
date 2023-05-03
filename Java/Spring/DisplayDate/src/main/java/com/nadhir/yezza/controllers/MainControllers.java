package com.nadhir.yezza.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.Date;
import java.text.SimpleDateFormat ;

@Controller
public class MainControllers {

	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	}
	
	@RequestMapping("/date")
	public String datePage(Model model) {
		SimpleDateFormat dateformat = new SimpleDateFormat("EEE, MMM d, yyyy");
		Date thisDay = new Date();
		model.addAttribute("date", dateformat.format(thisDay));
		return "date.jsp";
	}
	
	@RequestMapping("/time")
	public String timePage(Model model) {
		SimpleDateFormat timeformat = new SimpleDateFormat("h:mm a");
		Date nowTime = new Date();
		model.addAttribute("time", timeformat.format(nowTime));
		return "time.jsp";
	}
}
