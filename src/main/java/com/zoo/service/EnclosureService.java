package com.zoo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zoo.entity.Enclosure;
import com.zoo.repository.BuildingRepository;
import com.zoo.repository.EnclosureRepository;

@Service
public class EnclosureService {

	@Autowired
	private EnclosureRepository repo;
	
	
	@Autowired
	private BuildingRepository brepo;


	public List<Enclosure> getAllEnclosure() {
		return repo.findAll();
	}

	public String addEnclosure(Enclosure s) {

		repo.save(s);
		return"redirect:/enclosure/allEnclosure";
	}
	
	public String updateEnclosure(int id,Enclosure e)
	{
		Enclosure s = repo.findByEnclosureId(id);
		
		s.setSqft(e.getSqft());
		s.setBuildingId(e.getBuildingId());
		repo.save(s);

		return "redirect:/enclosure/allEnclosure";

	}

	public String deleteEnclosureById(int EnclosureId) {
		
		Enclosure s = repo.findByEnclosureId(EnclosureId);
		repo.deleteById(EnclosureId);
		return "Enclosure with "+EnclosureId+" deleted succesfully";
	}

	public Enclosure getEnclosureById(int id) {
	
		return repo.findByEnclosureId(id);
	}
}
