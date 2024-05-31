package org.example.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class AdminController {
    @GetMapping("/admin")
    public String admin(){
        return "admin";
    }

    @GetMapping("/accessDenied")
    public String accessDenied(){
        return "accessDenied";
    }
}
