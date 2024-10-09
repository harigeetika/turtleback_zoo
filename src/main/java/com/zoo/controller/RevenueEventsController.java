package com.zoo.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zoo.dto.AverageRevenueResponse;
import com.zoo.dto.AverageRevneue;
import com.zoo.dto.FiveBestDays;
import com.zoo.dto.FiveBestDaysRevenue;
import com.zoo.dto.RevenueBySource;
import com.zoo.dto.RevenueEventsDto;
import com.zoo.dto.RevenueReportBySource;
import com.zoo.dto.TopAttractions;
import com.zoo.dto.TopThreeAttractionsResponse;
import com.zoo.entity.RevenueEvents;
import com.zoo.service.RevenueEventsService;

@Controller
@RequestMapping("/revenueEvents")
public class RevenueEventsController {

	
	@Autowired
	private RevenueEventsService service;
	
	@GetMapping("/alll")
	public ResponseEntity<List<RevenueEvents>> allrevenueEven() {
			return service.alll();
		
	}
	

	
	@GetMapping("/all")
	public String allrevenueEvents(Model model) {
		model.addAttribute("events",service.getRevenueEvents());
		return "revenue_events";
		
	}
	
	
	@GetMapping("/add_event")
	public String addRevEvent() {
		return "add_event";
	}
	
	
	@PostMapping("/addEvent")
	public String addEvents(@ModelAttribute RevenueEventsDto rd) {
		return service.addEvent(rd);
	}
	
	
	
	@GetMapping("/revenueSource")
	public String revenueBySoruce()
	{
		return "revenue_by_source";
	}
	
	
	@PostMapping("/sourceDate")
	public String revenueBySoruce(@ModelAttribute RevenueReportBySource r,Model m)
	{
		System.out.println(r.getDate());
		List<RevenueBySource> b = service.getRevenueBySource(r.getDate());
		System.out.println(b);
		m.addAttribute("selectedDate", r.getDate());
		m.addAttribute("revenueSource",service.getRevenueBySource(r.getDate()));
		return "revenue_by_source";
	}
	
	
	@GetMapping("/revenueBestDays")
	public String revenueBestDays()
	{
		return "five_best_days";
	}
	
	
	@PostMapping("/fiveDays")
	public String fivebestdays(@ModelAttribute FiveBestDays f,Model m)
	{
		System.out.println(f.getMonth());
		String[] a = f.getMonth().split("-");
		int year= Integer.parseInt(a[0]);
		int month = Integer.parseInt(a[1]);
				
		
        Page<FiveBestDaysRevenue> resultsPage = service.getRevenueFiveDays(month, year, PageRequest.of(0, 5));
        List<FiveBestDaysRevenue> results = resultsPage.getContent();
        System.out.println(results);
        
        m.addAttribute("selectedMonth", f.getMonth());
        m.addAttribute("fiveDays",results);

		return "five_best_days";
	}
	
	
	
	@GetMapping("/averageRevenue")
	public String averageRevenue()
	{
		return "average_revenue";
	}
	
	
	@PostMapping("/avgRevenue")
	public String averageRevenueAttraction(@ModelAttribute AverageRevneue f,Model m)
	{
		System.out.println(f.getBeginDate());
		System.out.println(f.getEndDate());
		List<AverageRevenueResponse> r = service.averageRevenue(f.getBeginDate(),f.getEndDate());
		System.out.println(r);
		m.addAttribute("beginDate", f.getBeginDate());
		m.addAttribute("endDate", f.getEndDate());
        m.addAttribute("avgRev",service.averageRevenue(f.getBeginDate(),f.getEndDate()));

		return "average_revenue";
	}
	
	
	@GetMapping("/topAtt")
	public String topthreeAtt()
	{
		return "top_three_attractions";
	}
	
	
	@PostMapping("/topThreeAttractions")
	public String topThreeAttractions(@ModelAttribute TopAttractions f,Model m)
	{
		
		
		Page<TopThreeAttractionsResponse> resultsPage = service.getTopThreeAttractions(f.getBeginDate(), f.getEndDate(), PageRequest.of(0, 3));
        List<TopThreeAttractionsResponse> results = resultsPage.getContent();
        System.out.println(results);
        m.addAttribute("beginDate", f.getBeginDate());
		m.addAttribute("endDate", f.getEndDate());
        m.addAttribute("attractions",results);

		return "top_three_attractions";
	}
	
	
	
}
