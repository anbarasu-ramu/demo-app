package com.example.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	
	@RequestMapping("/hello")
	  public String hello() {
	    return "Hello Anbarasu, this is change in master branch!";
	  }
	
	
}
