package com.zoo.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
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
import org.springframework.web.bind.annotation.RestController;

//import com.zoo.entity.AnimalCareSpecialist;
//import com.zoo.entity.CustomerService;
import com.zoo.entity.Employee;
//import com.zoo.entity.MaintenanceStaff;
//import com.zoo.entity.TicketSeller;
//import com.zoo.entity.Veterinarian;
import com.zoo.service.EmployeeService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeService empService;


	@GetMapping("/allEmp")
	public String getAllEmp(Model model){
		model.addAttribute("employees",empService.getAllEmp());
		return "categories";
	}	
	
	
	@GetMapping("/add_emp")
	public String addEmployee(){
		return "add_emp";
	}
	
	@PostMapping(value="/addEmployee")
	public String addEmployee(@ModelAttribute Employee e) {
		
		System.out.println(e);
		return empService.addEmployee(e);
	}
	

	@GetMapping("/edit/emp/{id}")
	public String editEmployee(@PathVariable("id") int id,Model m){
		m.addAttribute("emp",empService.getEmployeeByEmpId(id));
		return "edit_emp";
	}
	
	
	@PostMapping(value="/updateEmployee/{id}")
	public String updateEmployee(@PathVariable("id") int id,@ModelAttribute Employee e) {
		System.out.println(id);
		System.out.println(e);
		return empService.updateEmployee(id,e);
	}
	
	
}
