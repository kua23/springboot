package com.amazon.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amazon.entity.Customer;
import com.amazon.repository.CustomerRepository;

@Service
public class CustomerService {
	@Autowired
	CustomerRepository customerRepository;
	
	public List<Customer> findAllCustomer(){
		return customerRepository.findAll();
	}
	
	public Customer findCustomerById(Long id) {
		return customerRepository.findById(id).orElseThrow(() -> new RuntimeException("Id not there"));
	}
	
	public Customer addCustomer(Customer customer) {
		return customerRepository.save(customer);
	}
	
	public void delCustomer(Long id) {
		customerRepository.deleteById(id);
	}
	
	public Customer updateCustomer(Long id, Customer updated) {
		Customer current = customerRepository.findById(id).orElseThrow(() -> new RuntimeException("Id nope"));
		current.setName(updated.getName());
		current.setEmail(updated.getEmail());
		current.setPhoneNumber(updated.getPhoneNumber());
		return customerRepository.save(current);
	}
}

