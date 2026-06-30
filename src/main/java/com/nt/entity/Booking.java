package com.nt.entity;

import java.time.LocalDate;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "CAB_BOOKING")
@Data
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookingId;

    @Column(nullable = false)
    private String pickupCity;

    @Column(nullable = false)
    private String dropCity;

    @Column(nullable = false)
    private LocalDate travelDate;

    @Column(nullable = false)
    private String tripType;

    @Column(nullable = false)
    private String cabType;

    @Column(nullable = false, length = 10)
    private String mobileNumber;
    
    @Column(nullable = false)
    private String email;

	/* private Double fare; */
}