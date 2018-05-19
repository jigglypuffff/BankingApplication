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
	BankRepository bankDao;

	static final Logger log = Logger.getLogger(BankService.class.getName()); 
	
	
	@Override
	public Bank createBank(final Bank bank) {
		log.info("Create bank");
		return bankDao.save(bank);

	}

	@Override
	public List<Bank> getBankDetails() {
		log.info("view bank details");
		return bankDao.findAll();
	}

	public Optional<Bank> getBankDetailById(final Integer id) {
		log.info("viewBankDetailsbyId");
		try {
			final Optional<Bank> bank = bankDao.findById(id);
			return bank;
		} catch (BankException e) {
			throw new BankException("Id not found");

		}

	}
}
