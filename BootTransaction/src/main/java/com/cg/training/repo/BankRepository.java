package com.cg.training.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cg.training.model.Bank;

/**
 * @author aishwarya
 *
 */
/* provides connection to database to perform bank related operations*/
public interface BankRepository extends JpaRepository<Bank, Integer>{

	@Query
	Optional<Bank> findByBankId(Integer bankId);

}
