package com.cg.training.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cg.training.model.ATM;



/**
 * @author aishwarya
 *
 */
/* provides connection to database to perform atm related operations*/
public interface AtmRepository extends JpaRepository<ATM, Integer> {

	@Query
	Optional<ATM> findByatmId(Integer getatmId);

	
}
