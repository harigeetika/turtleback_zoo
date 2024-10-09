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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.zoo.entity.Building;
import com.zoo.service.BuildingService;


@Controller
@RequestMapping("/building")
public class BuildingController {
	
	@Autowired
	private BuildingService buildService;


	@GetMapping("/allBuildings")
	public String getAllbuild(Model model){
		model.addAttribute("buildings",buildService.getAllBuilding());
		return "building";
	}

	
	
	@GetMapping("/add_building")
	public String addBuilding(){
		return "add_building";
	}
	
	
	@PostMapping(value="/addBuilding")
	public String addbuilding(@ModelAttribute Building e) {
		
		System.out.println(e);
		return buildService.addBuilding(e);
	}
	

	@GetMapping("/edit/{id}")
	public String editbuilding(@PathVariable("id") int id,Model m){
		m.addAttribute("build",buildService.getBuildingByBuildingId(id));
		return "edit_building";
	}
	
	
	@PostMapping(value="/updateBuilding/{id}")
	public String updatebuilding(@PathVariable("id") int id,@ModelAttribute Building e) {
		System.out.println(id);
		System.out.println(e);
		return buildService.updateBuilding(id,e);
	}
	
	

}
