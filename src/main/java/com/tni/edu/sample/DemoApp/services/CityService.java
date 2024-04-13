package com.tni.edu.sample.DemoApp.services;


import com.tni.edu.sample.DemoApp.entities.City;
import com.tni.edu.sample.DemoApp.repositories.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {

    @Autowired
    CityRepository cityRepository;

    public CityService(){}

    public List<City> getCities() {
        return cityRepository.findAll();
    }

    public City saveCity(City city) {
        return cityRepository.save(city);
    }

    public City getCity(String cityname) {
        return cityRepository.findByCityname(cityname);
    }
}
