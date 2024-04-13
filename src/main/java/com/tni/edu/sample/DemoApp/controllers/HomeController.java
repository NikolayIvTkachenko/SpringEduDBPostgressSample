package com.tni.edu.sample.DemoApp.controllers;


import com.tni.edu.sample.DemoApp.entities.City;
import com.tni.edu.sample.DemoApp.entities.Course;
import com.tni.edu.sample.DemoApp.pojos.CityRequest;
import com.tni.edu.sample.DemoApp.pojos.CourseRequest;
import com.tni.edu.sample.DemoApp.services.CityService;
import com.tni.edu.sample.DemoApp.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HomeController {

    @Autowired
    CityService cityService;

    @Autowired
    CourseService courseService;

    @GetMapping("sayHello")
    public String sayHello() {
        return "Hello User";
    }

    @GetMapping("getcities")
    public List<City> getCities(){
        return cityService.getCities();
    }

    @PostMapping("addcity")
    public City SaveCity(@RequestBody City city) {
        return cityService.saveCity(city);
    }

    @GetMapping("getcity")
    public City getCity(String cityname) {
        return cityService.getCity(cityname);
    }

    @PostMapping("savecity")
    public City addCity(@RequestBody CityRequest cityRequest) {
        return cityService.addCity(cityRequest);
    }


    @PostMapping("addcourse")
    public Course addCourse(@RequestBody CourseRequest courseRequest) {
        return courseService.addCourseWithContents(courseRequest);
    }


}
