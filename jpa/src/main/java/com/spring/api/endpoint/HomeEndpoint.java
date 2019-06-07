package com.spring.api.endpoint;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeEndpoint {

    @GetMapping("/")
    public String getHome() {
        return "JPA Api is up and running!";
    }
}
