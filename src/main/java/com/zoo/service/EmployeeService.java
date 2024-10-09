package com.zoo.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.zoo.entity.Employee;
//import com.zoo.entity.AnimalCareSpecialist;
//import com.zoo.entity.CustomerService;
//import com.zoo.entity.Employee;
//import com.zoo.entity.MaintenanceStaff;
//import com.zoo.entity.TicketSeller;
//import com.zoo.entity.Veterinarian;
import com.zoo.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository repo;





	
	public List<Employee> getAllEmp() {
		return repo.findAll();
	}


	
	public Employee getEmployeeByEmpId(int id) {
		
		return repo.findByEmpId(id);
	}
	


	public String updateEmployee(int empId, Employee v) {
		
		Employee e =  repo.findByEmpId(empId);
		System.out.println(e);
		
		e.setFirstName(v.getFirstName());
		e.setLastName(v.getLastName());
		e.setDob(v.getDob());
		e.setStartDate(v.getStartDate());
		e.setStreet(v.getStreet());
		e.setCity(v.getCity());
		e.setZipcode(v.getZipcode());
		e.setJobType(v.getJobType());
		e.setSuperEmpId(v.getSuperEmpId());
		e.setHourlyrateId(v.getHourlyrateId());
		repo.save(e);
		return "redirect:/employee/allEmp";

	}



	public String addEmployee(Employee emp) {
		
		repo.save(emp);
		return "redirect:/employee/allEmp";
	}
	
	

	
	
	
	
}
