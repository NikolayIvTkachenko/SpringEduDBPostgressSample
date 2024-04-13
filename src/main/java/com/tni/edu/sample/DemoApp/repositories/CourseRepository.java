package com.tni.edu.sample.DemoApp.repositories;


import com.tni.edu.sample.DemoApp.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course,Integer> {
    public Course findById(int id);
}
