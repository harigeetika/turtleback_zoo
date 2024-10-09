package com.zoo.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.zoo.dto.AnimalPopulation;
import com.zoo.dto.AverageRevenueResponse;
import com.zoo.dto.FiveBestDaysRevenue;
import com.zoo.dto.RevenueBySource;
import com.zoo.dto.RevenueEventsDto;
import com.zoo.dto.RevenueReportBySource;
import com.zoo.dto.TopThreeAttractionsResponse;
import com.zoo.entity.RevenueEvents;
import com.zoo.entity.RevenueType;
import com.zoo.repository.RevenueEventsRepository;
import com.zoo.repository.RevenueTypeRepository;

@Service
public class RevenueEventsService {

	
	@Autowired
	private RevenueEventsRepository repo;
	
	@Autowired
	private RevenueTypeRepository  trepo;
	



	public List<RevenueEvents> getRevenueEvents() {
		
		return repo.findAll();
	}


	public String addEvent(RevenueEventsDto rd) {
		// TODO Auto-generated method stub
		RevenueEvents revenueEvent = new RevenueEvents();
        revenueEvent.setDateTime(rd.getDateTime());
        RevenueType revenueType = trepo.findByRevenueId(rd.getRevenueId());
        revenueEvent.setRevenueType(revenueType);
        revenueEvent.setRevenue(rd.getRevenue());
        revenueEvent.setTicketsSold(rd.getTicketsSold());
        repo.save(revenueEvent);
		return "redirect:/revenueEvents/all";
	}


	public ResponseEntity<List<RevenueEvents>> alll() {
		
		return ResponseEntity.ok(repo.findAll());
	}


	public ResponseEntity<List<RevenueBySource>> getRevenueBySource1(LocalDate date) {
		
		List<RevenueBySource> r1 = repo.getRevenueBySourceDate(date);
		return ResponseEntity.ok(r1);
	}


	public List<RevenueBySource> getRevenueBySource(LocalDate localDate) {
		
		return repo.getRevenueBySourceDate(localDate);
	}


	public Page<FiveBestDaysRevenue> getRevenueFiveDays(int month, int year, PageRequest pageRequest) {
	
		return repo.getBestFiveDaysRevenue(year,month,PageRequest.of(0,5));
	}


	public List<AverageRevenueResponse> averageRevenue(LocalDate beginDate, LocalDate endDate) {
		
		return repo.getAverageRevenue(beginDate,endDate);
	}



	public Page<TopThreeAttractionsResponse> getTopThreeAttractions(LocalDate beginDate, LocalDate endDate,
			PageRequest of) {
		
		return repo.getTopThreeAttractions(beginDate,endDate,PageRequest.of(0, 3));
	}

	
}
