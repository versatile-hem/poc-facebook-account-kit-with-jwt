package com.wolftechnica.fb.accountkit.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class FBController {

	@GetMapping("/home")
	public String home() {
		return "home";
	}
 
	
	@PostMapping("/api/secured")
	public @ResponseBody String secured() {
		return "hello world";
	}
	
	 
}
