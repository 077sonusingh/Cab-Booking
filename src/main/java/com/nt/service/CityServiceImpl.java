package com.nt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.City;
import com.nt.repository.CityRepository;

@Service
public class CityServiceImpl implements ICityService{

    @Autowired
    private CityRepository repo;

    @Override
    public List<City> searchCity(String keyword){

        return repo.findByCityNameStartingWithIgnoreCase(keyword);

    }

}
