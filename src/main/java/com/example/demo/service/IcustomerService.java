package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Customer;



public interface IcustomerService {
		
	List<Customer> getAllCustomers();

	Customer addCustomer(Customer customer);
	List<Customer> getCustomersByFullName(String fullName);
	
}
