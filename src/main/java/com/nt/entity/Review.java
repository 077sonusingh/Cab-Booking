package com.nt.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "TAXI_REVIEW")
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

    // Customer profile image
    @Lob
    @Column(columnDefinition = "LONGBLOB")
    private byte[] image;

    // Date of review
    private LocalDate reviewDate;

    // Whether the review is approved
    private Boolean approved;
}