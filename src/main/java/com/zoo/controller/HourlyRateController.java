package com.zoo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zoo.entity.HourlyRate;
import com.zoo.entity.Species;
import com.zoo.service.HourlyRateService;

@Controller
@RequestMapping("/rate")
public class HourlyRateController {

	@Autowired
	private HourlyRateService service;
	
	@GetMapping("/allRate")
	public String getAllRate(Model model){
		List<HourlyRate> s = service.getAllRates();
		System.out.println(s);
		model.addAttribute("rates",service.getAllRates());
		return "rate";
	}
	
	@GetMapping("/add_rate")
	public String addVet(){
		return "add_rate";
	}
	
	
	@PostMapping(value="/addRate")
	public String addRate(@ModelAttribute HourlyRate s) {
		
		System.out.println(s);
		
		return service.addRates(s);
	}
	
	
	
	@GetMapping(value="/edit/{id}")
	public String updateRates(@PathVariable("id") int id,Model m) {
		m.addAttribute("rt",service.getHourlyRateById(id));
		return "edit_rate";
	}

	
	@PostMapping(value="/updateRate/{id}")
	public String updateCs(@PathVariable("id") int id,@ModelAttribute HourlyRate e) {
		
		System.out.println(e);
		return service.updateRate(id,e);
	}
	

}
