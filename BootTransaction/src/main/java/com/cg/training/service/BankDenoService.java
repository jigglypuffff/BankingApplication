package com.cg.training.service;

import java.math.BigDecimal;
import java.util.List;

import com.cg.training.model.Bank;
import com.cg.training.model.BankDenomination;
import com.cg.training.model.RefMoney;

public interface BankDenoService {

	BankDenomination addDemomination(Bank bankId, BigDecimal amount);

	List<RefMoney> createDenomination(Integer bankId);
	
	

}
