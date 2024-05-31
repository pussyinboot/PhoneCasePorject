package org.example.Service;

import lombok.extern.slf4j.Slf4j;
import org.example.repository.CustomerRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CustomerLoginService implements UserDetails {
    private final CustomerRepository customerRepository;

    public CustomerLoginService(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }
    @Override
    public UserDetails loadUserByUsername(String Customerid) throws
            UsernameNotFoundException {
}
