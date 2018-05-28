package com.cg.training.service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.training.model.AuditLog;
import com.cg.training.model.Bank;
import com.cg.training.model.Customer;
import com.cg.training.model.EventName;
import com.cg.training.model.EventType;
import com.cg.training.repo.BankRepository;
import com.cg.training.repo.CustomerRepository;
import com.cg.training.wrapper.CustomerUpdateWrapper;
import com.cg.training.wrapper.CustomerWrapper;

/**
 * @author aishwarya
 *
 */
@Service
public class CustomerServiceImpl implements CustomerService {
	static final Logger log = Logger.getLogger(CustomerService.class.getName());

	@Autowired
	CustomerRepository customerRepo;
	@Autowired
	BankServiceImpl bankService;
	@Autowired
	BankRepository bankRepository;
	@Autowired
	AuditService auditSer;

	@Override
	public Customer createCustomer(final CustomerWrapper customer) {
		log.info("create a new customer");

		final Optional<Bank> bankOpt = bankRepository.findByBankId(customer.getbId());

		final Bank bank = bankOpt.get();

		// if(bankOpt.isPresent())
		// {
		final Customer cust = customer.getCustomer();
		cust.setBankId(bank);
		return customerRepo.save(cust);
	}
	// else
	// {
	// throw new BankException("Customer or bank details is invalid");
	// }

	@Override
	public List<Customer> getCustomers() {
		log.info("view list of all customers");
		return customerRepo.findAll();
	}

	@Override
	public Optional<Customer> getCustomerDetailById(final Integer id) {
		log.info("view details of customer by id");
		Optional<Customer> customer = customerRepo.findByCustomerId(id);
		return customer;
	}

	public Customer updateCustomer(CustomerUpdateWrapper req,String newName) {
		Optional<Customer> customerOpt = customerRepo.findByCustomerId(req.getCustomerId());
		Customer customer = customerOpt.get();
		Customer oldCustomer;

		try {
			oldCustomer = customer.clone();

			customer.setName(newName);

			System.out.println(oldCustomer);
			System.out.println(customer);

			AuditLog audit = new AuditLog(EventName.Customer.toString(), EventType.Updated.toString(),
					customer.getUserId(), oldCustomer, customer);
			auditSer.create(audit);

			customerRepo.save(customer);

		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}

		return customer;

	}

}
