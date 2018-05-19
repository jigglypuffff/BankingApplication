package com.cg.training.BootTransaction;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.cg.training.controller.CustomerController;
import com.cg.training.repo.BankRepository;


@RunWith(SpringRunner.class)
@SpringBootTest
public class BootTransactionApplicationTests {

	/**
	 CustomerController reference 
	 */
	@Autowired
	CustomerController controller;
	
	@Autowired
	BankRepository bankRepo;
	

	
	
	@Test
	public void viewCust() {

		final String uri = "http://localhost:8080/customer/view";

		final RestTemplate restTemplate = new RestTemplate();
		final String result = restTemplate.getForObject(uri, String.class);
		System.out.println(result);
		assertEquals("true",result, controller.showCustomer());
	}
	
	
	
	
}
