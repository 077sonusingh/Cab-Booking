package com.nt.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="TAXI_REVIEW")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer reviewId;

    private String customerName;

    private String city;

    @Column(length = 1000)
    private String reviewMessage;

    private Integer rating;
}