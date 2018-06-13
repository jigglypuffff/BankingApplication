package com.cg.training.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.training.model.BankDenomination;
/**
 * @author aishwarya
 *
 */
public interface BankDenoRepo extends JpaRepository<BankDenomination, Integer>{
	
}


