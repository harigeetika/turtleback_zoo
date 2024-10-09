package com.zoo.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RevenueBySource {

    private int revenueId;
    private String revenueName;
    private String revenueType;
    private long revenue;
    private long ticketsSold;
}
