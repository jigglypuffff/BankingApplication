package com.cg.training.BootTransaction;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.training.exception.BankException;
import com.cg.training.model.Bank;
import com.cg.training.repo.BankRepository;
import com.cg.training.service.BankServiceImpl;


@RunWith(SpringRunner.class)
@SpringBootTest
public class BankTests {

	/**
	 CustomerController reference 
	 */

	@Mock
	BankRepository bankRepo;
	
	@InjectMocks
	BankServiceImpl bankSer;
	
	

	@Test
	public void createBank()
	{
		final Bank bank = new Bank(1,new BigDecimal(1000));
		when(bankRepo.save(bank)).thenReturn(bank);
		assertThat(bankSer.createBank(bank), is(notNullValue()));
	}
	
	
	
	@Test(expected=BankException.class)
	public void createBanks()
	{
		Bank bank = new Bank(-1,new BigDecimal(2000));
		when(bankSer.createBank(bank)).thenThrow(new BankException(" Zero or Negative Id Not Found"));
		
	}

}
		
	
