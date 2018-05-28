package com.cg.training.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.training.model.Bank;
import com.cg.training.model.BankDenomination;
import com.cg.training.model.RefMoney;
import com.cg.training.repo.BankDenoRepo;
import com.cg.training.repo.BankRepository;

@Service
public class BankDenoServImpl implements BankDenoService {
	private final static Logger log = Logger.getLogger(BankService.class.getName());

	@Autowired
	BankDenoRepo bdenoRepo;
	@Autowired
	BankRepository bankRepo;

	
	@Autowired
	RefService refService;
	@Override
	public BankDenomination addDemomination(final Bank bankId, final BigDecimal amount) {
/*
		final Optional<Bank> banks = bankRepo.findById(bankId.getBankId());
		final Bank bankOpt = banks.get();
		
		final BankDenomination bankdenom = new BankDenomination();
		bankdenom.setBankId(bankOpt);
		
		

			if (currencyValue.compareTo(remaining) == 0 || currencyValue.compareTo(remaining) == -1) {

				Integer set = remaining.divide(currencyValue).intValue();

				bankdenom.setNoOfDenomination(set);
				bankdenom.setDenomination(currencyValue.intValue());
				remaining = remaining.remainder(currencyValue);
				bdenoRepo.save(bankdenom);

				if (remaining.equals(0)) {
					break;
				}
			}
			currencyList.remove(index);

		}*/
		return null;
	}

	@Override
	public List<RefMoney> createDenomination(Integer bankId) {
		
		log.info("Creating Denominations For Bank");
		Optional<Bank> bankOpt = bankRepo.findByBankId(bankId);
		Bank bank = bankOpt.get();
		
		List<RefMoney> list=  refService.viewAll();
		
		/*for(list:)*/
		for (RefMoney refMoney : list) {
			
			System.out.println(refMoney);
				
		}
		
		BankDenomination bankDnm = new BankDenomination(bank, 0, 50); 
		BankDenomination bankDnm1 = new BankDenomination(bank, 0, 100);	
		BankDenomination bankDnm4 = new BankDenomination(bank, 0, 200);
		BankDenomination bankDnm3 = new BankDenomination(bank, 0, 500);
		
		
		bdenoRepo.save(bankDnm);
		bdenoRepo.save(bankDnm1);
		bdenoRepo.save(bankDnm3);
		bdenoRepo.save(bankDnm4);
		//BankDenomination bankDenom = new BankDenomination(bank,0,list);
		
		return list;
		
		
	}

	
}