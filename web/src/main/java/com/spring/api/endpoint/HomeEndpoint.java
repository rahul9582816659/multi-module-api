package com.spring.api.endpoint;

import com.spring.api.entity.Employee;
import com.spring.api.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
public class HomeEndpoint {

    @Autowired
    private HomeService homeService;

    /**
     *  This will work with @RequestParam  but not with @RequestBody
     *  This is will trim the extra space around.
     * @param dataBinder
     */
    /*@InitBinder
    public void initBinder(WebDataBinder dataBinder){
        System.out.println("initBinder");
        StringTrimmerEditor editor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, editor);
    }*/

    @Value("${rahul.email}")
    private String email;

    @GetMapping("/")
    public String getHome() {
        homeService.testAOP();
        return "Web Api is up and running, Email to " + email + " !";
    }

    @GetMapping("/get")
    public String getHomeWithParam(@RequestParam String name) {
        System.out.println(name);
        return "Get Mapping , " + name + " Email to " + email + " !";
    }

    @PostMapping("/post")
    public String getHomeWithReqBody(@RequestBody Employee employee) {
        System.out.println(employee);
        return "Post Mapping , " + employee.getName() + " Email to " + email + " !";
    }
}
