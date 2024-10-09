package com.zoo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HomeController {
	

	@GetMapping("/")
	public String home() {

		return "index";
	}
	
	
	@GetMapping("/asset")
	public String asset() {

		return "asset";
	}
	
	
	@GetMapping("/management")
	public String managementReporting() {

		return "management";
	}
	
	
	
	

}
