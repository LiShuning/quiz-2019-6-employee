package com.example.employee.controllers;

import com.example.employee.entity.Employee;
import com.example.employee.repopsitory.EmployeeRepository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeeController {
    private EmployeeRepository repository;

    public EmployeeController() {
        this.repository = new EmployeeRepository();
    }

    @RequestMapping(value = "/employees", method = RequestMethod.GET)
    public List<Employee> getAll() {
        return repository.findAll();
    }

    @RequestMapping(value = "/employees/{id}" , method = RequestMethod.GET)
    public Employee getById(@PathVariable String id) {
        return repository.findById(Integer.valueOf(id));
    }
}
