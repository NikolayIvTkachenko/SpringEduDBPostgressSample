package com.tni.edu.sample.DemoApp.controllers;


import com.tni.edu.sample.DemoApp.entities.Employee;
import com.tni.edu.sample.DemoApp.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("employees/")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @PostMapping("addemployees")
    public List<Employee> addAllEmployees(@RequestBody List<Employee> employees) {
        return employeeService.saveAllEmployees(employees);
    }

    @GetMapping("allemployees")
    public List<Employee> getAllEmployees() {
        return employeeService.findAllEmployees();
    }

    @GetMapping("employeeswithname")
    public List<Employee> getAllEmployeesWithName(@RequestBody String employeename) {
        return employeeService.findEmployeesByName(employeename);
    }

    @GetMapping("employeebyid")
    public Employee getEmployeeById(@RequestParam int id) {
        return employeeService.findEmployeeById(id);
    }

}
