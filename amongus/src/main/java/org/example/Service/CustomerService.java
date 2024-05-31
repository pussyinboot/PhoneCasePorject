package org.example.Service;

import lombok.RequiredArgsConstructor;
import org.example.models.Customer;
import org.example.repository.CustomerRepository;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.example.dto.SignUpDataTransferObject;

@RequiredArgsConstructor
@Service
public class CustomerService {
    private final CustomerRepository customerRepository;
    //private SignUpDataTransferObject signUpDataTransferObject;
    //private final PasswordEncoder passwordEncoder;//

    public Customer create(String Customerid, String CustomerPassword, String CustomerName, String PhoneNumber, String Email){
        //이게 repository를 이용한 sql 명령어 creat문 자바에서 쓰기//
        Customer customer = new Customer(); //빨간 줄이 그어져있었다. 뭔 시그니처 변경하라네 했는데 Customer 클래스에 기본 생성자를 추가해줬더니 해결됐다. 자바는 기본 생성자 자동 생성되는 걸로 알고 있는데//
            customer.setCustomerid(Customerid);
            customer.setCustomerName(CustomerName);
            customer.setPhoneNumber(PhoneNumber);
            customer.setEmail(Email);
            customer.setCustomerPassword(CustomerPassword);
            //BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            //customer.setCustomerPassword(passwordEncoder.encode(CustomerPassword));
            //customer.setCustomerPassword(passwordEncoder.encode(CustomerPassword));
            this.customerRepository.save(customer);
            return customer;
    }
}
