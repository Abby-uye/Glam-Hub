package com.beautyClan.glamhub.data.repositories;

import com.beautyClan.glamhub.data.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
    Customer findByBioData_EmailEquals(String email);
}
