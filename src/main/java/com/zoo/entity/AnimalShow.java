package com.zoo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="animal_show")
@Data
@AllArgsConstructor
@NoArgsConstructor
@PrimaryKeyJoinColumn(name="aid")
public class AnimalShow extends RevenueType{

	
	private int childPrice;
	private int adultPrice;
	private int seniorPrice;
	private int showsPerDay;
}
