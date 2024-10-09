package com.zoo.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="building")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Building {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private int buildingId;
	private String buildingName;
	private String purpose;
	private int noOfFloors; 
	
}
