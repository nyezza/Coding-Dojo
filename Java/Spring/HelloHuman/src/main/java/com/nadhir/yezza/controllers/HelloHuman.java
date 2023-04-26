package com.nadhir.yezza.controllers;

import org.apache.tomcat.util.buf.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("/")
public class HelloHuman {
	
//	@RequestMapping("/")
//	public String humain() {
//		return "Hello Human";
//	}
	
	@RequestMapping("/")
	public String helloName(@RequestParam(value="name" ,required = false) String name, @RequestParam(value="Last_Name",required=false) String last_name) {
		if (name!=null & last_name==null) {
		return "hello " + name;
		}
		else if (name!=null & last_name != null){
			return "Hello " + name +" "+ last_name;
		}
		else {
			return "Hello Human";
		}
	}
	
	
	@RequestMapping("nametime")
	public String helloTime(@RequestParam(value="name") String name, @RequestParam(value="time") int time) {
		//for (int i=0;i<time;i++) {
		//
		System.out.println(String);
		String message = "hello" + name;
		return StringUtils.repeat(message, time);
		//}
	}
}
