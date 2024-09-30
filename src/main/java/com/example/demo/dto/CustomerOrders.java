package com.example.demo.dto;

import java.util.List;

import com.example.demo.model.Customer;
import com.example.demo.model.Order;

import lombok.Data;

@Data
public class CustomerOrders {
	private Customer customer;
	private List<Order> order;
	

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<Order> getOrder() {
		return order;
	}

	public void setOrder(List<Order> order) {
		this.order = order;
	}

	public CustomerOrders(Customer customer, List<Order> order) {
		super();
		this.customer = customer;
		this.order = order;
	}

	public CustomerOrders() {
		super();
	}
}