package com.amazon.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.amazon.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
