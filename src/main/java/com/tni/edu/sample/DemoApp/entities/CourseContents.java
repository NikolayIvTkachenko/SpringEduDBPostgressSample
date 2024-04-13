package com.tni.edu.sample.DemoApp.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "coursecontents")
public class CourseContents {

    @Id
    @Column(name= "content_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name= "content")
    private String content;

    @ManyToMany(mappedBy = "coursecontentsset")
    @JsonIgnore
    private Set<Course> courses = new HashSet<>();

    public void addCourse(Course course) {
        this.courses.add(course);
    }

    @Override
    public String toString() {
        return "CourseContents{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", courses=" + courses +
                '}';
    }
}
