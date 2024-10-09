package com.zoo.controller;

import java.util.ArrayList;
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

import com.zoo.dto.AnimalShowDto;
import com.zoo.entity.AnimalShow;
import com.zoo.entity.ConcessionStands;
import com.zoo.entity.RevenueType;
import com.zoo.entity.Species;
import com.zoo.entity.ZooAdmission;
import com.zoo.repository.RevenueTypeRepository;
import com.zoo.service.RevenueTypeService;

@Controller
@RequestMapping("/revenue")
public class RevenueTypeController {

	@Autowired
	private RevenueTypeService revService;
	
	
	@Autowired
	private RevenueTypeRepository repo;
	
	
	//-----------ANIMAL SHOW
	
	@GetMapping("/allAnimalShows")
	public String allAnimalShows(Model m) {
		m.addAttribute("shows", revService.getRevenueByType("Animal Show"));
		return "animalshows";
	}
	

	@GetMapping("/add_animalshow")
	public String addVet(){
		return "add_animalshow";
	}
	
	
	@PostMapping(value="/addAnimalShow")
	public String addSpecies(@ModelAttribute AnimalShow s) {
		
		System.out.println(s);
		return revService.addAnimalShow(s);
	}
	
	
	@GetMapping(value="/edit/animalshow/{id}")
	public String updateAnimalShow(@PathVariable("id") int id,Model m) {
		m.addAttribute("as",revService.getAnimalShowById(id));
		return "edit_animalshow";
	}

	
	@PostMapping(value="/updateAnimalShow/{id}")
	public String updateCs(@PathVariable("id") int id,@ModelAttribute AnimalShow e) {
		
		System.out.println(e);
		return revService.updateAnimalShow(id,e);
	}
	
	
	//-------------------Concession Stands
	@GetMapping("/allConcessions")
	public String getAllConcesion(Model model){
		List<RevenueType> s = revService.getRevenueByType("Concession");
		System.out.println(s);
		model.addAttribute("concessions",revService.getRevenueByType("Concession"));
		return "concession";
	}
	

	@GetMapping("/add_concession")
	public String addconcesion(){
		return "add_concession";
	}
	
	
	@PostMapping(value="/addConcession")
	public String addConcession(@ModelAttribute ConcessionStands s) {
		
		System.out.println(s);
		return revService.addConcession(s);
	}
	
	
	@GetMapping(value="/edit/concession/{id}")
	public String updateConcession(@PathVariable("id") int id,Model m) {
		m.addAttribute("con",revService.getConcessionById(id));
		return "edit_concession";
	}

	
	@PostMapping(value="/updateConcession/{id}")
	public String updateConcesion(@PathVariable("id") int id,@ModelAttribute ConcessionStands e) {
		
		System.out.println(e);
		return revService.updateConcession(id,e);
	}

	
	
	//-------------------Zoo Admission
	
	
	@GetMapping("/allZooAdmission")
	public String getAllZooAd(Model model){
		List<RevenueType> s = revService.getRevenueByType("Zoo Admission");
		System.out.println(s);
		model.addAttribute("zooadm",revService.getRevenueByType("Zoo Admission"));
		return "zooad";
	}
	
	
	
	@GetMapping("/add_za")
	public String addZooAdd() {
		return "add_za";
	}
	
	
	@PostMapping("/addZa")
	public String addZA(@ModelAttribute ZooAdmission a) {
		return revService.addZA(a);
	}
	
	@GetMapping("/edit/za/{id}")
	public String editbuilding(@PathVariable("id") int id,Model m){
		m.addAttribute("za",revService.getAdById(id));
		return "edit_za";
	}
	
	
	@PostMapping(value="/updateZA/{id}")
	public String updatebuilding(@PathVariable("id") int id,@ModelAttribute ZooAdmission e) {

		return revService.updateZA(id,e);
	}
	
}
