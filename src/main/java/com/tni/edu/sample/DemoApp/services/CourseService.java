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

    public CourseService() {
    }

    public Course addCourseWithContents(CourseRequest courseRequest) {
        Course course = new Course();

        System.out.println("----------------");
        System.out.println(courseRequest);

        System.out.println(courseRequest.coursecontents.size());
        System.out.println("=================");

        course.setId(courseRequest.id);
        course.setCoursename(courseRequest.coursename);
        course.setCoursecontentsset(
                courseRequest.coursecontents
                        .stream()
                        .map(
                                coursecontent -> {
                                    System.out.println("coursecontent.id = " + coursecontent.getId());
                                    System.out.println("coursecontent = " + coursecontent);

                                    CourseContents ccontents = coursecontent; //new CourseContents();
                                    System.out.println("ccontents= " + ccontents);
//                                    ccontents.setId(coursecontent.getId());
//                                    ccontents.setContent(coursecontent.getContent());
//                                    ccontents.setCourses(coursecontent.getCourses());

                                    if (ccontents.getId() > 0) {
                                        ccontents = courseContentRepository.findById(ccontents.getId());
                                    }
                                    ccontents.addCourse(course);  //.getCourses().add(course);
                                    return ccontents;
                                })
                        .collect(Collectors.toSet()));
        return courseRepository.save(course);
    }

}
