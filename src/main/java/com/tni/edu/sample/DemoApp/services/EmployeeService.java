package com.tni.edu.sample.DemoApp.services;

import com.tni.edu.sample.DemoApp.entities.Employee;
import com.tni.edu.sample.DemoApp.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    public EmployeeService() {}

    public List<Employee> saveAllEmployees(List<Employee>  employees) {
        return employeeRepository.saveAll(employees);
    }

    public List<Employee> findAllEmployees() {
        return employeeRepository.findAll();
    }

    public List<Employee> findAllEmployeesByIds(List<Integer> ids) {
        return employeeRepository.findAllById(ids);
    }

    public Employee findEmployeeById(int id) {
        return employeeRepository.findById(id);
    }

    public List<Employee> findEmployeesByName(String employeename) {
        return employeeRepository.findByEmployeename(employeename);
    }

}
