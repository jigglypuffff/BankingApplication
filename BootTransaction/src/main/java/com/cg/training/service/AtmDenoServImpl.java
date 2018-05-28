/*package com.cg.training.service;

import java.util.Optional;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.training.model.ATM;
import com.cg.training.model.AtmDenomination;
import com.cg.training.repo.AtmDenoRepo;
import com.cg.training.repo.AtmRepository;

@Service
public class AtmDenoServImpl implements AtmDenoService{
	
	private final static Logger log = Logger.getLogger(AtmService.class.getName());
		@Autowired
		AtmDenoRepo adenoRepo;

		@Autowired
		AtmRepository atmRepo;

		@Override
		public void createDenomination(Integer atmId) {
			log.info("Creating Denominations For Atm");
			Optional<ATM> atmOpt = atmRepo.findById(atmId);
			ATM atm = atmOpt.get();
			AtmDenomination atmDm0 = new AtmDenomination(atm, 0, 50);
			AtmDenomination atmDm = new AtmDenomination(atm, 0, 100);
			AtmDenomination atmDm1 = new AtmDenomination(atm, 0, 200);
			AtmDenomination atmDm2 = new AtmDenomination(atm, 0, 500);
			AtmDenomination atmDm3 = new AtmDenomination(atm, 0, 2000);
			adenoRepo.save(atmDm0);
			adenoRepo.save(atmDm);
			adenoRepo.save(atmDm1);
			adenoRepo.save(atmDm2);
			adenoRepo.save(atmDm3);

		}

	}


*/