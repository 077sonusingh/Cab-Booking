package com.nt.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "CONTACT_US")
@Data
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer contactId;

    @Column(nullable = false)
    private String fullName;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false,length = 10)
    private String mobileNumber;

    @Column(nullable = false)
    private String subject;

    @Column(nullable = false,length = 1000)
    private String message;

}
