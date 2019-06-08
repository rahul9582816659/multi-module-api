package com.spring.api.endpoint;

import com.spring.api.entity.Employee;
import com.spring.api.service.AOPService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AOPEndpoint {

    @Autowired
    private AOPService aopService;

    @GetMapping("/aop")
    public List<String> findAll(@RequestParam int id){
        return aopService.findAll(id);
    }

    @PostMapping("/aop")
    public List<String> findAll(@RequestBody Employee employee){
        return aopService.findAll(employee);
    }
}
