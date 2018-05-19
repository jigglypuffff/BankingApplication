package com.cg.training.service;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.training.exception.BankException;
import com.cg.training.model.ATM;
import com.cg.training.model.AtmRequest;
import com.cg.training.model.AtmWrapper;
import com.cg.training.model.Bank;
import com.cg.training.repo.AtmRepository;
import com.cg.training.repo.BankRepository;

/**
 * @author aishwarya
 *
 */
@Service
public class AtmServiceImpl implements AtmService{

	static final Logger log =  Logger.getLogger(AtmService.class.getName());
	/**
	 Bank Repository reference 
	 */
	@Autowired
	BankRepository bankDao;
	
	/**
	 AtmRepository reference 
	 */
	@Autowired
	AtmRepository atmRepo;
	@Override
	public ATM createAtm(final AtmWrapper atm) {
		log.info("create atm");
		
		try {
		final Optional<Bank> bankId = bankDao.findById(atm.getBankId());
		
		final Bank bank = bankId.get();
		
		final ATM trueatm  = atm.getAtm();
		
		trueatm.setBankId(bank);
		
		return atmRepo.save(trueatm);
		}
		catch(BankException e)
		{
			throw new BankException("id not found");
		}
		
		 
	}

	@Override
	public String addMoneyFromBank(final AtmRequest req) {
		
		log.info("add money from bank");
		
		try {
		final Optional<ATM> atmId=atmRepo.findById(req.getAtm().getatmId());
		final ATM trueAtm = atmId.get();
		
		final Optional<Bank> bid = bankDao.findById(req.getbId());
		final Bank trueBank = bid.get();
		
		final BigDecimal bAmount = trueBank.getAmount();
		
		final BigDecimal aAmount = req.getAtm().getAmount();
		
		final BigDecimal result = bAmount.add(aAmount);
		
		trueAtm.setAmount(result);
		
		atmRepo.save(trueAtm);
		
		return "success";
		}
		catch(BankException e)
		{
			throw new BankException("id not found");
		}
		
	}


	
	

	@Override
	public String withdrawMoney(final AtmRequest req) {
		
		log.info("withdraw money from atm");
		
		try {
		final Optional<ATM> atmId =atmRepo.findById(req.getAtm().getatmId());
		final ATM trueAtm = atmId.get();
		
		final Optional<Bank> bid = bankDao.findById(req.getbId());
		final Bank trueBank = bid.get();
		
		final BigDecimal bAmount = trueBank.getAmount();
		
		final BigDecimal aAmount = req.getAtm().getAmount();
		
		final BigDecimal result = bAmount.subtract(aAmount);
		
		trueAtm.setAmount(result);
		
		atmRepo.save(trueAtm);
		
		return "success";
		}
		catch(BankException e)
		{
			throw new BankException("insufficient balance");
		}
		
		
	}

}
