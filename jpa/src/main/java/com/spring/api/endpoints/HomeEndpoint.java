package com.spring.api.endpoints;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeEndpoint {

    @GetMapping("/")
    public String getHome() {
        return "Api is up and running!";
    }
}
