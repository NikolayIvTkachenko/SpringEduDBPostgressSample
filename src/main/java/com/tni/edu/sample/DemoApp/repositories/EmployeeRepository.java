package com.tni.edu.sample.DemoApp.repositories;

import com.tni.edu.sample.DemoApp.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    Employee findById(int id);
    List<Employee> findByEmployeename(String employeename);

    List<Employee> findByDepartmentAndAgeLessThan(String department, int age);

    List<Employee> findByEmployeenameStartingWith(String employeename);

    List<Employee> findByEmployeenameContaining(String employeename);

    List<Employee> findByEmployeenameEndingWith(String employeename);

}
