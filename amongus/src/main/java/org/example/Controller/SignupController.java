package org.example.Controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.Service.CustomerService;
import org.example.dto.SignUpDataTransferObject;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@RequiredArgsConstructor
@Controller
public class SignupController {

    private final CustomerService customerService;

    @GetMapping("/signup")
    public String SignUp(){
        return "Signup";
    }
    @PostMapping("/signup")
    public String signup(@Valid SignUpDataTransferObject signUpDataTransferObject, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "Signup";
        }
        if (!signUpDataTransferObject.getCustomPassword().equals(signUpDataTransferObject.getCustomPasswordCheck())) {
            bindingResult.rejectValue("CustomPassword", "CustomPasswordCheck",
                    "2개의 패스워드가 일치하지 않습니다.");
            return "Signup";
        }
        customerService.create(signUpDataTransferObject.getCustomerId(), signUpDataTransferObject.getCustomPassword(),
                signUpDataTransferObject.getCustomerName(), signUpDataTransferObject.getPhoneNumber(),
                signUpDataTransferObject.getEmail());
        return "Home";
    }
}
