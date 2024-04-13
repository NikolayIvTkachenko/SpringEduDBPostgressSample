package com.tni.edu.sample.DemoApp.services;


import com.tni.edu.sample.DemoApp.entities.City;
import com.tni.edu.sample.DemoApp.entities.Country;
import com.tni.edu.sample.DemoApp.pojos.CityRequest;
import com.tni.edu.sample.DemoApp.repositories.CityRepository;
import com.tni.edu.sample.DemoApp.repositories.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {

    @Autowired
    CityRepository cityRepository;

    @Autowired
    CountryRepository countryRepository;

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

    public City addCity(CityRequest cityRequest) {
        Country country = countryRepository.findById(cityRequest.country_id);
        City city = new City();
        city.setCityname(cityRequest.cityname);
        city.setCitycode(cityRequest.citycode);
        city.setCountryid(cityRequest.country_id);
        city.setCountry(country);
        return cityRepository.save(city);
    }
}
