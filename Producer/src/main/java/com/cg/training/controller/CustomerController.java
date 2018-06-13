package com.cg.training.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.cg.training.model.Customer;
import com.cg.training.service.BankService;
import com.cg.training.service.CustomerService;
import com.cg.training.wrapper.CustomerUpdateWrapper;
import com.cg.training.wrapper.CustomerWrapper;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;

/**
 * @author aishwarya
 *
 */
@RestController
@RequestMapping("/customer")
public class CustomerController {

	/**
	 * 
	 */
	@Autowired
	BankService bankSer;
	/**
	 * 
	 */
	@Autowired
	CustomerService custSer;

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public Customer addCustomer(final @RequestBody CustomerWrapper customer) {
	return custSer.createCustomer(customer);
	}

	@RequestMapping(value = "/view", method = RequestMethod.GET)
	public List<Customer> showCustomer() {
		return custSer.getCustomers();
	}


	@RequestMapping(value = "/update/{newName}", method = RequestMethod.PUT)
	public Customer updateCustomer(@RequestBody CustomerUpdateWrapper req,@PathVariable String newName) throws JsonGenerationException, JsonMappingException, IOException {
		return custSer.updateCustomer(req,newName);
	}
	
	
	
	
}
