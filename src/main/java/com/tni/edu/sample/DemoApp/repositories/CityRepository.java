package com.tni.edu.sample.DemoApp.repositories;

import com.tni.edu.sample.DemoApp.entities.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CityRepository extends JpaRepository<City, Long> {

    City findByCityname(String cityname);
}
