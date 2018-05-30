package com.cg.training.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cg.training.model.Customer;


/**
 * @author aishwarya
 *
 */
/* provides connection to database to perform customer related operations*/
public interface CustomerRepository extends JpaRepository<Customer,Integer>{

	@Query
	Optional<Customer> findByCustomerId(Integer id);

}
