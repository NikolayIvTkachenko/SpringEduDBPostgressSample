package com.tni.edu.sample.DemoApp.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.type.descriptor.jdbc.TimestampWithTimeZoneJdbcType;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.ZonedDateTime;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "employees")
public class Employee implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private int id;

    @Column(name = "employeename")
    private String employeename;

    @Column(name = "department")
    private String department;

    @Column(name = "joiningdate")
    private Date joiningdate;

    @Column(name = "age")
    private int age;

    @Column(name = "address")
    private String address;

    @Column(name = "salary")
    private float salary;

    @Column(name = "lefton")
    private ZonedDateTime lefton;
    //private Date lefton;
    //private TimestampWithTimeZoneJdbcType lefton;


    @Column(name = "leftjob")
    private boolean leftjob;



}
