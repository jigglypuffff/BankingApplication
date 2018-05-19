package com.cg.training.service;

import java.util.List;

import com.cg.training.model.Customer;
import com.cg.training.model.CustomerWrapper;

public interface CustomerService {

	
	/**
	 * @param customer
	 * @return new customer
	 */
	 Customer createCustomer(CustomerWrapper customer);
	/**
	 * @return list of customers
	 */
	 List<Customer> getCustomers();

}
