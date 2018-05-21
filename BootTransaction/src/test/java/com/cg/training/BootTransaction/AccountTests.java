/*package com.cg.banking;

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
import com.cg.training.repo.AccountRepository;
import com.cg.training.repo.BankRepository;
import com.cg.training.repo.CustomerRepository;
import com.cg.training.service.AccountServiceImpl;



@RunWith(SpringRunner.class)
@SpringBootTest
public class AccountTest {

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
		final Bank bank = new Bank(1,new BigDecimal(1000));
		
		Optional<Bank> bnk = Optional.of(bank);
		
		final Customer customer = new Customer(1, bank, "aishu", 4842);
		customer.setCustomerId(4);
		Optional<Customer> cust = Optional.of(customer);
		
		Account account = new Account(new BigDecimal(4000),1,1);
		
		
		AccountRequest accReq=new AccountRequest(1, 4, account);
		
		when(bankRepo.findById(Mockito.any(Integer.class))).thenReturn(bnk);
				
		when(custRepo.findById(Mockito.any(Integer.class))).thenReturn(cust);
		
		when(accRepo.save(account)).thenReturn(account);
		assertThat(accSer.createAccount(accReq), is(notNullValue()));

	}
	
	@Test(expected=BankException.class)
	public void createAccounts() {
		Bank bank=new Bank(new BigDecimal(1200));
		//bank.setId(1);
		//Optional<Bank> bnk = Optional.of(bank);
		final Optional<Bank> banks = Optional.empty();

		Customer customer=new Customer("ritika",2131,bank);
		//customer.setCustomerId(4);
		//Optional<Customer> cust = Optional.of(customer);\
		final Optional<Customer> customers = Optional.empty();

		
		Account account = new Account(customer,new BigDecimal(4000),bank);
		AccountRequest accReq=new AccountRequest(1, 4, account);
		
		when(bankRepo.findById(Mockito.any(Integer.class))).thenReturn(banks);
				
		when(custRepo.findById(Mockito.any(Integer.class))).thenReturn(customers);
		
		//when(accRepo.save(account)).thenReturn(account);
		when(accSer.createAccount(accReq)).thenThrow(new BankException("details invalid"));


	}
}
*/