package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.Customer;
import com.example.demo.repo.CustomerRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Service
public class CustomerService implements IcustomerService {

	@Autowired
	private	CustomerRepository repo;

	@PersistenceContext
	private EntityManager entityManager;

	public List<Customer> getAllCustomers() {
		return repo.findAll();
	}

	@Transactional
	public Customer addCustomer(Customer customer) {
		Integer lastId = (Integer) entityManager.createQuery("SELECT MAX(c.customerId) FROM Customer c")
				.getSingleResult();
		if (lastId != null) {
			customer.setCustomerId(lastId + 1);
		} else {
			customer.setCustomerId(1); // If there are no records, start with 1
		}
		return repo.save(customer);
	}

	@Override
	public List<Customer> getCustomersByFullName(String fullName) {
		// TODO Auto-generated method stub
		return null;
	}
	
}


