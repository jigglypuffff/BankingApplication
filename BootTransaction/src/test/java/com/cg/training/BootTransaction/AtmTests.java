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

import com.cg.training.model.ATM;
import com.cg.training.model.Bank;
import com.cg.training.repo.AtmRepository;
import com.cg.training.repo.BankRepository;
import com.cg.training.service.AtmServiceImpl;
import com.cg.training.wrapper.AtmWrapper;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AtmTests {
	
	@Mock
	AtmRepository atmRepo;
	
	@Mock
	BankRepository bankRepo;
	
	@InjectMocks
	AtmServiceImpl atmSer;
	
	@Test
	public void createAtm()
	{
		AtmWrapper req = new AtmWrapper(1,new BigDecimal(5000));
		final Bank bank = new Bank(1, new BigDecimal(1000));
		Optional<Bank> bnk = Optional.of(bank);
		ATM atm = new ATM(new BigDecimal(5000),bank);
		
		when(bankRepo.findById(Mockito.any(Integer.class))).thenReturn(bnk);
		
		when(atmRepo.save(atm)).thenReturn(atm);
		
		assertThat(atmSer.createAtm(req), is(notNullValue()));
		
	}
	

}
