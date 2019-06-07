package com.spring.api.service;

import com.spring.api.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HomeService {

    public void addHome() {
        System.out.println("HomeService Called");
    }

    public void addHomeWithParam(Employee employee) {
        System.out.println("HomeService Called");
    }

    public List<Employee> getEmployees() {
        System.out.println("HomeService Called");

        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee("Rahul"));
        employeeList.add(new Employee("Shalu"));

        return employeeList;
    }

    public List<Employee> findEmployee(boolean flag) {
        if (flag) {
            throw new RuntimeException("employees not found : Throwing Exception");
        }
        return null;
    }
}
