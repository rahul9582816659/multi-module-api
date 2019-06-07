package com.spring.api.endpoint;

import com.spring.api.entity.Employee;
import com.spring.api.service.DashboardService;
import com.spring.api.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HomeEndpoint {

    @Autowired
    private HomeService homeService;

    @Autowired
    private DashboardService dashboardService;


    @Value("${rahul.email}")
    private String email;

    @GetMapping("/")
    public List<Employee> getHome() {
        homeService.addHome();
        homeService.addHomeWithParam(new Employee("Rahul"));
        dashboardService.addDashboard();

        List<Employee> list = null;
        try {
            boolean flag = true;
           list = homeService.findEmployee(flag);
        } catch (Exception e) {
            System.out.println("caught Exception : " + e);
        }


        return homeService.getEmployees();

        // return "AOP Api is up and running, Email to " + email + " !";
    }
}
