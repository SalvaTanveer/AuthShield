package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import com.example.demo.service.AuthenticationService;

@Controller
@RequestMapping("/api")
public class UserController {
	
	AuthenticationService authService;
	@Autowired
	public UserController(AuthenticationService authService) {
		// TODO Auto-generated constructor stub
		this.authService = authService;
	}
	
	@RequestMapping("/")
	public String home() {
		return "login";
	}
	
	@PostMapping("/auth/login")
	public String login(@RequestParam("un")String username, @RequestParam("up")String password) {
		String result = authService.verifyUser(username, password);
		if(result.equalsIgnoreCase("success")) {
			return "verify";
		}else {
			return "login";
		}

	}
	
	@PostMapping("/auth/verify")
	public String verifyOtp(@RequestParam("otp")String otp) {
		String result = authService.verify(otp);
		if(result.equalsIgnoreCase("failure")) {
			return "verify";
		}else if(result.equalsIgnoreCase("expired")) {
			return "login";
		}else {
			return "success";
		}	
	}
	
}
