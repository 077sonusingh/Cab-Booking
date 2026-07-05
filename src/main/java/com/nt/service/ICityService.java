package com.nt.service;

import java.util.List;

import com.nt.entity.City;

public interface ICityService {

    List<City> searchCity(String keyword);

}
