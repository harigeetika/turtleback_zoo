package com.zoo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zoo.entity.Animal;
import com.zoo.entity.Building;
import com.zoo.repository.AnimalRepository;
import com.zoo.repository.BuildingRepository;

@Service
public class BuildingService {

	@Autowired
	private BuildingRepository repo;
	
	public List<Building> getAllBuilding(){
		List<Building> a = repo.findAll();
		System.out.println(a);
		return a;
	}
	
	
	public String addBuilding(Building b) {

		repo.save(b);
		return "redirect:/building/allBuildings";
	}


	public String updateBuilding(int id, Building e) {
		// TODO Auto-generated method stub
		Building build = repo.findByBuildingId(id);
		
		build.setBuildingName(e.getBuildingName());
		build.setNoOfFloors(e.getNoOfFloors());
		build.setPurpose(e.getPurpose());
		System.out.println(build);
		repo.save(build);
		return "redirect:/building/allBuildings";
	
	}


	public String deletebuildingById(int buildingId) {
		// TODO Auto-generated method stub
		Building build = repo.findByBuildingId(buildingId);
		repo.deleteById(buildingId);
		return "Building with "+buildingId+" deleted succesfully";
		
	}


	public Building getBuildingByBuildingId(int id) {
		// TODO Auto-generated method stub
		return repo.findByBuildingId(id);
	}


}
