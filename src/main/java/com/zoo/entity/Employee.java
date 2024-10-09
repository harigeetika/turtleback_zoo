package com.zoo.entity;

import java.time.LocalDate;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="employee")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private int empId;
	private String firstName;
	private String lastName; 
	private LocalDate startDate;
	private LocalDate dob;
	private String jobType;
	private String street;
	private String city;
	private int zipcode;
	private Integer superEmpId;
	private int hourlyrateId;
	private Integer cid;
	private Integer zaId;
	
	
}
