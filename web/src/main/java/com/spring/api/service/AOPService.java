package com.spring.api.service;

import com.spring.api.dao.AOPDao;
import com.spring.api.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AOPService {

    @Autowired
    private AOPDao aopDao;

    public List<String> findAll(int id) {
        return aopDao.findAll(id);
    }

    public List<String> findAll(Employee employee) {
        return aopDao.findAll(employee);
    }
}
