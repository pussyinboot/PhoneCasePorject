package org.example.repository;

import org.example.models.Customer;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerLoginRepository {
    Optional<Customer> findByCustomerId(String Customerid);
}
