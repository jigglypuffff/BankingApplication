package com.cg.training.service;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.logging.Logger;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.training.exception.BankException;
import com.cg.training.model.ATM;
import com.cg.training.model.Bank;
import com.cg.training.model.Customer;
import com.cg.training.repo.AtmRepository;
import com.cg.training.repo.BankRepository;
import com.cg.training.wrapper.AtmRequest;
import com.cg.training.wrapper.AtmWrapper;

/**
 * @author aishwarya
 *
 */
@Service
public class AtmServiceImpl implements AtmService {

	static final Logger log = Logger.getLogger(AtmServiceImpl.class.getName());
	/**
	 * Bank Repository reference
	 */
	@Autowired
	BankRepository bankRepo;
	@Autowired
	BankServiceImpl bankServiceImpl;

	/**
	 * AtmRepository reference
	 */
	@Autowired 
	AtmRepository atmRepo;

	@Override
	public ATM createAtm(final AtmWrapper atm) { 
		log.info("create atm");

		try {

			ATM newatm = new ATM();
			newatm.setAmount(atm.getAmount());
			newatm.setBankId(bankServiceImpl.getBankDetailById(atm.getBankId()).get());

			return atmRepo.save(newatm);
		} catch (BankException e) {
			throw new BankException("id not found");
		}

	}

	@Transactional
	@Override
	public String addMoneyFromBank(final AtmRequest req) {

		log.info("add money from bank");

		try {

			final Optional<ATM> atmId = atmRepo.findByatmId(req.getAtm().getatmId());
			final ATM trueAtm = atmId.get();

			final Bank trueBank = bankServiceImpl.getBankDetailById(req.getbId()).get();
	
			final BigDecimal atmAmount = req.getAtm().getAmount();

			final BigDecimal addAmount = req.getAmount();

			final BigDecimal result = addAmount.add(atmAmount);

			trueAtm.setAmount(result);

			atmRepo.save(trueAtm);

			final BigDecimal bankAmount = trueBank.getAmount();

			final BigDecimal newBankAmount = bankAmount.subtract(addAmount);

			trueBank.setAmount(newBankAmount);

			bankRepo.save(trueBank);

			return "success";
		} catch (BankException e) {
			throw new BankException("id not found");
		}

	}

	@Transactional
	@Override
	public String withdrawMoney(final AtmRequest req) {
		try {
			log.info("withdraw money from atm");
			
			final Optional<ATM> atmId = atmRepo.findByatmId(req.getAtm().getatmId());
			final ATM trueAtm = atmId.get();

			final Bank trueBank = bankServiceImpl.getBankDetailById(req.getbId()).get();
			
			final BigDecimal atmAmount = req.getAtm().getAmount();

			final BigDecimal addAmount = req.getAmount();

			final BigDecimal result = atmAmount.subtract(addAmount);

			trueAtm.setAmount(result);

			atmRepo.save(trueAtm);

			return "success";
		} catch (BankException e) {
			throw new BankException("insufficient balance");
		}

	}

	@Override
	public Optional<ATM> getAtmDetailById(final Integer id) {
		Optional<ATM> atm = atmRepo.findByatmId(id);
		return atm;
	}
}
