package com.zoo.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.zoo.entity.RevenueType;
import com.zoo.entity.Species;
import com.zoo.entity.AnimalShow;
import com.zoo.entity.Building;
import com.zoo.entity.ZooAdmission;
import com.zoo.entity.ConcessionStands;
import com.zoo.repository.BuildingRepository;
import com.zoo.repository.RevenueTypeRepository;
import com.zoo.repository.SpeciesRepository;

@Service
public class RevenueTypeService {

	
	@Autowired
	private RevenueTypeRepository repo;
	
	@Autowired
	SpeciesRepository sprepo;
	
	
	@Autowired
	private BuildingRepository brepo;


	
	
	public List<RevenueType> getall(){
		return repo.findAll();
	}
	
	
	public List<RevenueType> getRevenueByTyp(String type){
		
		return repo.findRevenueType(type);
	}

	
	public List<RevenueType> getRevenueByType(String type){
		
		return repo.findRevenueType(type);
	}



	public String addAnimalShow(AnimalShow ani) {
		    
		ani.setRevenueType("Animal Show");
		repo.save(ani);
		return "redirect:/revenue/allAnimalShows";
	}


	public AnimalShow getAnimalShowById(int id) {
		
		AnimalShow a = (AnimalShow) repo.findByRevenueId(id);
		return a;
	}


	public String updateAnimalShow(int id, AnimalShow ani) {
	
		AnimalShow a = (AnimalShow) repo.findByRevenueId(id);
		    
		a.setAdultPrice(ani.getAdultPrice());
		a.setBuildingId(ani.getBuildingId());
		a.setChildPrice(ani.getChildPrice());
		a.setSeniorPrice(ani.getSeniorPrice());
		a.setRevenueName(ani.getRevenueName());
		a.setShowsPerDay(ani.getShowsPerDay());
		a.setRevenueType("Animal Show");
		repo.save(a);
		return "redirect:/revenue/allAnimalShows";

	}



	//---------------Concession
	
	

	public String addConcession(ConcessionStands s) {
	
	    
		s.setRevenueType("Concession");
		repo.save(s);
		return "redirect:/revenue/allConcessions";
		
	}


	public ConcessionStands getConcessionById(int id) {
		
		return (ConcessionStands) repo.findByRevenueId(id);
	}


	public String updateConcession(int id, ConcessionStands e) {
		
		ConcessionStands a = (ConcessionStands) repo.findByRevenueId(id);
	    
		a.setBuildingId(e.getBuildingId());
		a.setProducts(e.getProducts());
		a.setRevenueName(e.getRevenueName());
		a.setRevenueType("Concession");
		repo.save(a);
		return "redirect:/revenue/allConcessions";
	
	}

    //-------------------Zoo Admission
	

	public String updateZA(int id, ZooAdmission e) {
	
		ZooAdmission v =(ZooAdmission) repo.findByRevenueId(id);
		v.setAdultPrice(e.getAdultPrice());
		v.setChildPrice(e.getChildPrice());
		v.setSeniorPrice(e.getSeniorPrice());
		v.setRevenueName(e.getRevenueName());
		v.setRevenueType("Zoo Admission");
		repo.save(v);
		return "redirect:/revenue/allZooAdmission";
	}

	public ZooAdmission getAdById(int id) {
		
		return (ZooAdmission) repo.findByRevenueId(id);
	}


	public String addZA(ZooAdmission e) {
		// TODO Auto-generated method stub
		e.setRevenueType("Zoo Admission");
		repo.save(e);
		return "redirect:/revenue/allZooAdmission";
	}
	


}
