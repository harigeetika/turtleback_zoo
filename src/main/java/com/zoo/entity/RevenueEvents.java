package com.zoo.entity;

import java.time.LocalDate;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "revenue_events")
@IdClass(RevenueEventsId.class)
public class RevenueEvents {

    @Id
    @Column(name="date_time")
    private LocalDate dateTime;

    @Id
    @ManyToOne
    @JoinColumn(name = "revenue_id")
    private RevenueType revenueType;
    
    
    private int revenue;

    private int ticketsSold;


}
