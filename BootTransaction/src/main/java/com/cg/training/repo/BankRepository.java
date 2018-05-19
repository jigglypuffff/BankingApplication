package com.cg.training.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.training.model.Bank;

/**
 * @author aishwarya
 *
 */
/* provides connection to database to perform bank related operations*/
public interface BankRepository extends JpaRepository<Bank, Integer>{

}
