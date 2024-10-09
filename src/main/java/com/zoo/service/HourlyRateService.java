package com.zoo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zoo.entity.HourlyRate;
import com.zoo.entity.Species;
import com.zoo.repository.HourlyRateRepository;

@Service
public class HourlyRateService {

	@Autowired
	private HourlyRateRepository repo;

	public List<HourlyRate> getAllRates() {
		
		return repo.findAll();
	}

	public String addRates(HourlyRate s) {
		System.out.println(s);
		repo.save(s);
		return"redirect:/rate/allRate";
	}

	public String updateRate(int id, HourlyRate e) {
		HourlyRate s = repo.findByHourlyrateId(id);
		s.setJobType(e.getJobType());
		s.setRate(e.getRate());
		repo.save(s);

		return "redirect:/rate/allRate";
	}

	public String deleteRateById(int rateId) {
		HourlyRate s = repo.findByHourlyrateId(rateId);
		repo.deleteById(rateId);
		return "Hourly Rate with "+rateId+" deleted succesfully";
	}

	public HourlyRate getHourlyRateById(int id) {
		
		return repo.findByHourlyrateId(id);
	}
	
	
	
}
