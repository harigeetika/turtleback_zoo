package com.zoo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zoo.entity.Enclosure;
import com.zoo.service.EnclosureService;

@Controller
@RequestMapping("/enclosure")
public class EnclosureController {

	
	@Autowired
	private EnclosureService enclosureService;
	
	
	
	@GetMapping("/allEnclosure")
	public String getAllEnclosure(Model model){
		List<Enclosure> s = enclosureService.getAllEnclosure();
		System.out.println(s);
		model.addAttribute("enclosure",enclosureService.getAllEnclosure());
		return "Enclosure";
	}
	
	@GetMapping("/add_enclosure")
	public String addVet(){
		return "add_enclosure";
	}
	
	
	@PostMapping(value="/addEnclosure")
	public String addEnclosure(@ModelAttribute Enclosure s) {
		
		System.out.println(s);
		return enclosureService.addEnclosure(s);
	}
	
	
	
	@GetMapping(value="/edit/{id}")
	public String updateEnclosure(@PathVariable("id") int id,Model m) {
		m.addAttribute("en",enclosureService.getEnclosureById(id));
		return "edit_enclosure";
	}

	
	@PostMapping(value="/updateEnclosure/{id}")
	public String updateCs(@PathVariable("id") int id,@ModelAttribute Enclosure e) {
		
		System.out.println(e);
		return enclosureService.updateEnclosure(id,e);
	}
	

}
