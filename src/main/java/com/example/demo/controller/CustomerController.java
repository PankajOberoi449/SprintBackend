package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Customer;
import com.example.demo.service.IcustomerService;



@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/v1/customers")
public class CustomerController {
	
	@Autowired
	private IcustomerService customerService;

	@GetMapping
	public ResponseEntity<List<Customer>> getAllCustomers(
			@RequestParam(name = "name", required = false) String fullName)  {
//		throws ResourceNotFoundException
		if (fullName != null) {
			List<Customer> customersByFullName = customerService.getCustomersByFullName(fullName);
			if (customersByFullName.isEmpty()) {
//				throw new ResourceNotFoundException("Name is not found");
			}
			return ResponseEntity.ok(customersByFullName);
		} else {
			List<Customer> allCustomers = customerService.getAllCustomers();
			if (allCustomers.isEmpty()) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(allCustomers);
			}
			return ResponseEntity.ok(allCustomers);
		}
	}

	@PostMapping
	public ResponseEntity<String> addCustomer(@RequestBody Customer customer) {
//		throws BadRequestException
		if (customer.getEmailAddress() == null || customer.getFullName() == null || customer.getEmailAddress().isEmpty()
				|| customer.getFullName().isEmpty()) {
//			throw new BadRequestException("Invalid request. Please provide valid customer data.");
		}

		customerService.addCustomer(customer);
		return ResponseEntity.status(HttpStatus.OK).body("Record Created Successfully");
	}
	
	
}
