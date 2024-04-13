package com.tni.edu.sample.DemoApp.pojos;

import com.tni.edu.sample.DemoApp.entities.CourseContents;

import java.util.Set;

public class CourseRequest {

    public int id;
    public String coursename;

    public Set<CourseContents> coursecontents;


    @Override
    public String toString() {
        return "CourseRequest{" +
                "id=" + id +
                ", coursename='" + coursename + '\'' +
                ", coursecontents=" + coursecontents +
                '}';
    }
}
