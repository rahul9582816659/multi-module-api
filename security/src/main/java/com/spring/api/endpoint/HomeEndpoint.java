package com.spring.api.endpoint;

import com.spring.api.entity.Employee;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class HomeEndpoint {

    private static Logger logger = Logger.getLogger(HomeEndpoint.class.getName());


    @GetMapping("/name")
    public Employee getHome(){
        return new Employee("Rahul Choudhary");
    }

}
