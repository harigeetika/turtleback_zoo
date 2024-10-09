package com.zoo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zoo.entity.Species;

import com.zoo.service.SpeciesService;


@Controller
@RequestMapping("/species")
public class SpeciesController {

	
	@Autowired
	private SpeciesService speciesService;
	
	
	
	@GetMapping("/allSpecies")
	public String getAllSpecies(Model model){
		List<Species> s = speciesService.getAllSpecies();
		System.out.println(s);
		model.addAttribute("species",speciesService.getAllSpecies());
		return "species";
	}
	
	@GetMapping("/add_species")
	public String addVet(){
		return "add_species";
	}
	
	
	@PostMapping(value="/addSpecies")
	public String addSpecies(@ModelAttribute Species s) {
		
		System.out.println(s);
		return speciesService.addSpecies(s);
	}
	
	
	
	@GetMapping(value="/edit/{id}")
	public String updateSpecies(@PathVariable("id") int id,Model m) {
		m.addAttribute("sp",speciesService.getSpeciesById(id));
		return "edit_species";
	}

	
	@PostMapping(value="/updateSpecies/{id}")
	public String updateCs(@PathVariable("id") int id,@ModelAttribute Species e) {
		
		System.out.println(e);
		return speciesService.updateSpecies(id,e);
	}
	
}
