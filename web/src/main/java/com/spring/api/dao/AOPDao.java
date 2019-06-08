package com.spring.api.dao;

import com.spring.api.entity.Employee;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AOPDao {

    public List<String> findAll(int id) {

        List<String> users = new ArrayList<>();
        users.add("Rahul");
        users.add("Shalu");
        return users;
    }

    public List<String> findAll(Employee employee) {
        List<String> users = new ArrayList<>();
        users.add("Rahul");
        users.add("Shalu");
        return users;
    }
}
