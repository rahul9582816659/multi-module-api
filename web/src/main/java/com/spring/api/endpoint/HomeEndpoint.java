package com.spring.api.endpoint;

import com.spring.api.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

@RestController
public class HomeEndpoint {

    private static Logger logger = Logger.getLogger(HomeEndpoint.class.getName());


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
        return "Web Api is up and running, Email to " + email + " !";
    }

    @GetMapping("/get")
    public String getHomeWithParam(@RequestParam String name) {
        logger.info(name);
        return "Get Mapping , " + name + " Email to " + email + " !";
    }

    @PostMapping("/post")
    public String getHomeWithReqBody(@RequestBody Employee employee) {
        logger.info(String.valueOf(employee));
        return "Post Mapping , " + employee.getName() + " Email to " + email + " !";
    }
}
