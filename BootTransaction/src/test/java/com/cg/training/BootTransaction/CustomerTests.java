package com.cg.training.BootTransaction;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.training.exception.BankException;
import com.cg.training.model.Bank;
import com.cg.training.model.Customer;
import com.cg.training.repo.BankRepository;
import com.cg.training.repo.CustomerRepository;
import com.cg.training.service.CustomerServiceImpl;
import com.cg.training.wrapper.CustomerWrapper;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerTests {

	@Mock
	CustomerRepository custRepo;

	@Mock
	BankRepository bankRepo;

	@InjectMocks
	CustomerServiceImpl custSer;

	@Test
	public void createCustomer() {
		Bank bank = new Bank(1, new BigDecimal(1000));
		Optional<Bank> ob = Optional.of(bank);

		final Customer customer = new Customer(1, bank, "aishu", 4842);

		final CustomerWrapper cust = new CustomerWrapper(1, customer);

		when(bankRepo.findById(Mockito.any(Integer.class))).thenReturn(ob);
		when(custRepo.save(customer)).thenReturn(customer);

		assertThat(custSer.createCustomer(cust), is(notNullValue()));
	

	}

	

	@Test(expected = BankException.class)
	public void createCustomers() {
		final Bank bank = new Bank(1,new BigDecimal(1000));

		final Optional<Bank> ob = Optional.empty();
		final Customer customer = new Customer(1, bank, "aishu", 4842);
		
		when(bankRepo.findById(Mockito.any(Integer.class))).thenReturn(ob);
		when(custRepo.save(customer)).thenReturn(customer);

	}

}
