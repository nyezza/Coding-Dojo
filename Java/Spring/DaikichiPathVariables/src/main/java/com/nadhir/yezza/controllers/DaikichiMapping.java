package com.nadhir.yezza.controllers;

import java.text.Format;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/daikichi")
public class DaikichiMapping {
	
	@RequestMapping("")
	public String Hello() {
		return "hello";
	}
	
	@RequestMapping("/travel/{location}")
	public String locationReturn(@PathVariable("location") String location) {
		return ("Congratulation! You wil  soon travel to " + location);
	}
	
	@RequestMapping("/{name}/{number}")
	public String daikichiReturn(@PathVariable("name") String name,@PathVariable("number") Integer number) {
		if (number % 2 ==0) {
			return "You will take a grand journey in the near future, but be weary of tempting offers";
		}
		else {
			return "you have enjoyed the fruits of your labor but now is a great time to spend time with family and friends."; 
		}
		
	}
}
