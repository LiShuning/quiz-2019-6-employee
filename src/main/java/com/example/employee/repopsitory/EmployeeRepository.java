package com.example.employee.repopsitory;

import com.example.employee.entity.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeRepository {
    private List<Employee> list = new ArrayList<>();

    public EmployeeRepository() {
        list.add(new Employee(0, "小明", 20, "男"));
        list.add(new Employee(1, "小红", 20, "女"));
        list.add(new Employee(2, "小智", 20, "男"));
        list.add(new Employee(3, "小刚", 20, "男"));
        list.add(new Employee(4, "小霞", 20, "女"));

    }

    public List<Employee> findAll() {
        return list;
    }

    public Employee findById(int id) {
        return list.stream().filter(v -> v.getId() == id).findFirst().get();
    }

    public boolean insert(Employee employee) {
        try {
            list.add(employee);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean deleteById(int id) {
        try {
            list = list.stream().filter(v -> v.getId() != id).collect(Collectors.toList());
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean updateById(int id, Employee employee) {
        try {
            list.stream().map(v -> v.getId() == id ? employee : v);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}