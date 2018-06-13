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
import com.cg.training.model.Account;
import com.cg.training.model.Bank;
import com.cg.training.model.Customer;
import com.cg.training.model.Transaction;
import com.cg.training.repo.AccountRepository;
import com.cg.training.repo.BankRepository;
import com.cg.training.repo.CustomerRepository;
import com.cg.training.service.AccountServiceImpl;
import com.cg.training.wrapper.AccountWrapper;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AccountTests {

	@Mock
	private AccountRepository accRepo;

	@Mock
	private CustomerRepository custRepo;

	@Mock
	private BankRepository bankRepo;

	@InjectMocks
	private AccountServiceImpl accSer;

	@Test
	public void createAccount() { 
		
		final Bank bank = new Bank(1, new BigDecimal(1000));

		Optional<Bank> bnk = Optional.of(bank);

		final Customer customer = new Customer(1, bank, "aishu", 4842);
		
		Optional<Customer> cust = Optional.of(customer);

		Account acc = new Account(1, customer, new BigDecimal(1000), bank);

		AccountWrapper accReq = new AccountWrapper(new BigDecimal(4000), 4, 1);

		when(bankRepo.findByBankId(Mockito.any(Integer.class))).thenReturn(bnk);

		when(custRepo.findByCustomerId(Mockito.any(Integer.class))).thenReturn(cust);

		when(accRepo.save(acc)).thenReturn(acc);
		
		assertThat(accSer.createAccount(accReq), is(notNullValue()));

	}

		@Test(expected = BankException.class)
		public void createAccounts() {
		
		final Bank bank = new Bank(1, new BigDecimal(1000));
		
		final Optional<Bank> banks = Optional.empty();

		Customer customer = new Customer(1, bank, "aishu", 4842);

		final Optional<Customer> customers = Optional.empty();

		Account acc = new Account(1, customer, new BigDecimal(1000), bank);

		AccountWrapper accReq = new AccountWrapper(new BigDecimal(4000), 4, 1);

		when(bankRepo.findByBankId(Mockito.any(Integer.class))).thenReturn(banks);

		when(custRepo.findByCustomerId(Mockito.any(Integer.class))).thenReturn(customers);

		when(accSer.createAccount(accReq)).thenThrow(new BankException("details invalid"));

	}
		
		
		@Test
		public void viewAccountById()
		{
			
			final Bank bank = new Bank(1, new BigDecimal(1000));
			
			final Optional<Bank> banks = Optional.empty();

			Customer customer = new Customer(1, bank, "aishu", 4842);

			final Optional<Customer> customers = Optional.empty();
			
			Account acc = new Account(1, customer, new BigDecimal(1000), bank);
			
			Optional<Account> account = Optional.of(acc);

			AccountWrapper accReq = new AccountWrapper(new BigDecimal(4000), 4, 1);
			
			Optional<AccountWrapper> req = Optional.of(accReq);
			
			when(accRepo.findByAccountId(1)).thenReturn(account);
			
			assertThat(accSer.getAccountDetailsById(1), is(notNullValue()));
			
			
		}
		
		
}
