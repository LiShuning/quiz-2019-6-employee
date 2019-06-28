package com.example.employee.controllers;

import com.example.employee.entity.Employee;
import com.example.employee.repopsitory.EmployeeRepository;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(value = "/employees", method = RequestMethod.POST)
    public String add(@ModelAttribute Employee employee) {
        return repository.insert(employee) ? "添加成功" : "添加失败";
    }

    @RequestMapping(value = "/employees/{id}", method = RequestMethod.DELETE)
    public String delete(@PathVariable String id) {
        return repository.deleteById(Integer.valueOf(id)) ? "删除成功" : "删除失败";
    }

    @RequestMapping(value = "employees/{id}", method = RequestMethod.PUT)
    public String update(@PathVariable String id, @ModelAttribute Employee employee) {
        return repository.updateById(Integer.valueOf(id), employee) ? "更新成功" : "更新失败";
    }
}
