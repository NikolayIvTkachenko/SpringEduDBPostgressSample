package com.tni.edu.sample.DemoApp.repositories;


import com.tni.edu.sample.DemoApp.entities.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository  extends JpaRepository<Country, Long> {

    Country findById(int id);

}