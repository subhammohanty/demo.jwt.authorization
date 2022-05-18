package com.example.jwt.authorization.demo.jwt.authorization.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Home {
	
	
	@RequestMapping("/welcome")
	public String welcome() {
		return  "This is a Private Page";
	}

}
