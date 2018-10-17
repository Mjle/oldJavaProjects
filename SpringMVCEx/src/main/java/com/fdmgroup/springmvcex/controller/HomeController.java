package com.fdmgroup.springmvcex.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

	@RequestMapping(value="/")
	public String goHome(){
		return "index";
	}
	
	@RequestMapping(value="/login")
	public String goToLogin(){
		return "login";
	}
	
	@RequestMapping(value="/register")
	public String goToRegisterPage(){
		return "register";
	}
}
