package com.tni.edu.sample.DemoApp.services;


import com.tni.edu.sample.DemoApp.entities.Course;
import com.tni.edu.sample.DemoApp.entities.CourseContents;
import com.tni.edu.sample.DemoApp.pojos.CourseRequest;
import com.tni.edu.sample.DemoApp.repositories.CourseContentRepository;
import com.tni.edu.sample.DemoApp.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class CourseService {

    @Autowired
    CourseContentRepository courseContentRepository;

    @Autowired
    CourseRepository courseRepository;

    public CourseService(){}

    public Course addCourseWithContents(CourseRequest courseRequest) {
        Course course = new Course();

        course.setId(courseRequest.id);
        course.setCoursename(courseRequest.coursename);
        course.setCourseContentsSet(
                courseRequest.courseContents
                        .stream()
                        .map(coursecontent -> {
                            CourseContents ccontents = coursecontent;
                            if (ccontents.getId() > 0) {
                                ccontents = courseContentRepository.findById(ccontents.getId());
                            }
                            ccontents.getCourses().add(course);
                            return ccontents;
                        })
                        .collect(Collectors.toSet())
        );

        return courseRepository.save(course);
    }

}
