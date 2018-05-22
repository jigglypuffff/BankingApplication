 package com.cg.training.service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.training.exception.BankException;
import com.cg.training.model.Bank;
import com.cg.training.repo.BankRepository;

/**
 * @author aishwarya
 *
 */
@Service
public class BankServiceImpl implements BankService {

	/**
	 
	 */
	@Autowired 
	BankRepository bankRepo;

	static final Logger log = Logger.getLogger(BankService.class.getName()); 
	
	
	@Override
	public Bank createBank(final Bank bank) {
		
		if(bank.getBankId()>=1)
		{
			log.info("Create bank");
		
			return bankRepo.save(bank);
		}
		else
		{
			throw new BankException("Zero or Negative Id Not Found");
		}

	}

	@Override
	public List<Bank> getBankDetails() {
		log.info("view bank details");
		return bankRepo.findAll();
	}
	
	
	@Override
	public Optional<Bank> getBankDetailById(final Integer id) {
		log.info("viewBankDetailsbyId");
		try {
			final Optional<Bank> bank = bankRepo.findById(id);
			return bank;
		} catch (BankException e) {
			throw new BankException("Id not found");

		}

	}
}
