package com.cg.training.service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.training.exception.BankException;
import com.cg.training.model.Bank;
import com.cg.training.model.Customer;
import com.cg.training.model.CustomerWrapper;
import com.cg.training.repo.BankRepository;
import com.cg.training.repo.CustomerRepository;

/**
 * @author aishwarya
 *
 */
@Service
public class CustomerServiceImpl implements CustomerService {
	static final Logger log = Logger.getLogger(CustomerService.class.getName());
	
	@Autowired
	CustomerRepository customerDao;
	@Autowired
	BankRepository bankRepository;

	@Override
	public Customer createCustomer(final CustomerWrapper customer) {
		log.info("create a new customer");
		try {
		final Optional<Bank> bankOpt = bankRepository.findById(customer.getbId());
		final Bank bank = bankOpt.get();
			final Customer cust = customer.getCustomer();
			cust.setBankId(bank);
			return customerDao.save(cust);
		} catch(BankException e)
		{
			throw new BankException ("id not found");
			
		}
	}

	@Override
	public List<Customer> getCustomers() {
		log.info("view list of all customers");
		return customerDao.findAll();
	}

}