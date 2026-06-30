package com.nt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.entity.Review;

public interface ReviewRepository extends JpaRepository<Review,Integer>{

}