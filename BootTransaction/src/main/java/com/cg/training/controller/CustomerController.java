package com.cg.training.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cg.training.model.Customer;
import com.cg.training.service.BankService;
import com.cg.training.service.CustomerService;
import com.cg.training.wrapper.CustomerWrapper;

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

}
