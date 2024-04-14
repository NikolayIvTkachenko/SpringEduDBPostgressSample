package com.tni.edu.sample.DemoApp.repositories;

import com.tni.edu.sample.DemoApp.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    Employee findById(int id);
    List<Employee> findByEmployeename(String employeename);

}
