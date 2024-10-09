package com.zoo.dto;

import java.time.LocalDate;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RevenueEventsDto {
	

	    private LocalDate dateTime;
	    private int revenueId;
	    private int revenue;
	    private int ticketsSold;
}
