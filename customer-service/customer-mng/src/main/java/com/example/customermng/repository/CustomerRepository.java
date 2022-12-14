package com.example.customermng.repository;

import java.util.Optional;

import com.example.customermng.domain.Customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

	Optional<Customer> findByCustomerIdentifier(String customerIdentifier);

}
