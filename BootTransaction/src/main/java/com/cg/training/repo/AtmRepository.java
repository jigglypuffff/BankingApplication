package com.cg.training.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.training.model.ATM;



/**
 * @author aishwarya
 *
 */
/* provides connection to database to perform atm related operations*/
public interface AtmRepository extends JpaRepository<ATM, Integer> {

	
}
