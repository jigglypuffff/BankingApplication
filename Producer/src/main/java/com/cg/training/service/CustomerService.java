package com.cg.training.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import com.cg.training.model.Bank;
import com.cg.training.model.Customer;
import com.cg.training.wrapper.CustomerUpdateWrapper;
import com.cg.training.wrapper.CustomerWrapper;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;

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
	 

	Optional<Customer> getCustomerDetailById(Integer id);
	
	Customer updateCustomer(CustomerUpdateWrapper req,String newName) throws JsonGenerationException, JsonMappingException, IOException;

}
