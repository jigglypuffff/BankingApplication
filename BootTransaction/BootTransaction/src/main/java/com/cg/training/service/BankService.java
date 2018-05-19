package com.cg.training.service;

import java.util.List;
import java.util.Optional;

import com.cg.training.model.Bank;

/**
 * @author aishwarya
 *
 */
public interface BankService {

	 /**
	 * @param bank
	 * @return
	 */
	Bank createBank(Bank bank);
	 /**
	 * @return
	 */
	List<Bank> getBankDetails();
	 /**
	 * @param id
	 * @return
	 */
	Optional<Bank> getBankDetailById(Integer id);
}
