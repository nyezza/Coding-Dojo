package com.nadhir.yezza;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// 2. Importing Dependencies
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class FirstprojectApplication {

	public static void main(String[] args) {
		SpringApplication.run(FirstprojectApplication.class, args);
	}
	
	//1.Annotation
	@RequestMapping("/")
	//3. Method of maps to the request route above
	public String Hello() {
		return "Hello World!";
	}
	
	@RequestMapping("/nedhir")
	public String HelloNedhir() {
		return "hello Nedhir";
	}

}
