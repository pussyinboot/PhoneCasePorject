package Service;

import lombok.extern.slf4j.Slf4j;
import org.example.models.Customer;
import org.example.repository.CustomerLoginRepository;
import org.example.repository.CustomerRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class CustomerLoginService implements UserDetailsService {
    private final CustomerLoginRepository customerLoginRepository;

    public CustomerLoginService(CustomerLoginRepository customerLoginRepository){
        this.customerLoginRepository = customerLoginRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String Customerid) throws
            UsernameNotFoundException {

        Optional<Customer> customer = customerLoginRepository.findByCustomerId(Customerid);
        if (customer.isPresent()) {
            Customer customer1 = customer.get();

            Customer authAdmin = Customer.builder()
                    .id(customer1.getId())
                    .Customerid(customer1.getCustomerid())
                    .CustomerPassword(customer1.getPassword())
                    .CustomerName(customer1.getCustomerName())
                    .role(customer1.getRole())
                    .createdAt(customer1.getCreatedAt())
                    .updatedAt(customer1.getUpdatedAt())
                    .build();
            log.info("authAdmin : {}", authAdmin);
            return authAdmin;
        }
        return null;
    }
}
