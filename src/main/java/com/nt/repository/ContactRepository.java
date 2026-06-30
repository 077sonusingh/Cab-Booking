package com.nt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.entity.Contact;

public interface ContactRepository extends JpaRepository<Contact, Integer> {

}
