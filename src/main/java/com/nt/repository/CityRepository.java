package com.nt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.entity.City;

public interface CityRepository extends JpaRepository<City,Integer>{

    List<City> findByCityNameStartingWithIgnoreCase(String keyword);

}
