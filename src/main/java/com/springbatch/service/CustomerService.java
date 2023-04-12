package com.springbatch.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbatch.model.Customer;
import com.springbatch.repository.CustomerRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class CustomerService {
	@Autowired
	private CustomerRepository repo;
	
	
	public void saveData(Customer customer) {
		repo.save(customer);
	}
}
