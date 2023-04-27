package com.nadhir.yezza.controllers;

import org.apache.tomcat.util.buf.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("/")
public class HelloHuman {
	
	// 1. Hello Human
//	@RequestMapping("")
//	public String humain() {
//		return "Hello Human";
//	}
	
	// 2. Hello + Name + LastName
	
//	@RequestMapping("")
//	public String helloName(@RequestParam(value="name" ,required = false) String name, @RequestParam(value="Last_Name",required=false) String last_name) {
//		if (name!=null & last_name==null) {
//		return "hello " + name;
//		}
//		else if (name!=null & last_name != null){
//			return "Hello " + name +" "+ last_name;
//		}
//		else {
//			return "Hello Human";
//		}
//	}
	
	// 3. Hello + name * time
	@RequestMapping("")
	public void helloTime(@RequestParam(value="name") String name, @RequestParam(value="time") int time) {
		int i=0;
		while (i<time) {
			System.out.println("hello "+ name);
			i= i+1;
		}
	}
}
