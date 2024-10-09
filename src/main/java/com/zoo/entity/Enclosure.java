package com.zoo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name="enclosure")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Enclosure {
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private int enclosureId;
	
	private int sqft;
	
	
	private int buildingId;
	


}
