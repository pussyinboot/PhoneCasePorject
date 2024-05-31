package org.example.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class CustomerController {
    @GetMapping("/notadmin")
    public String admin(){
        return "notadmin";
    }
    @GetMapping("/accessDenied")
    public String accessDenied(){
        return "accessDenied";
    }
}
