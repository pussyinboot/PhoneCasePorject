package org.example.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CartController {
    @GetMapping("/home/cart")
    public String Cart(){
        return "Cart";
    }
}
