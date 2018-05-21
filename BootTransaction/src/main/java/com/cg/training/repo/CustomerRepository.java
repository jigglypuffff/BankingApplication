package com.cg.training.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.training.model.Customer;


/**
 * @author aishwarya
 *
 */
/* provides connection to database to perform customer related operations*/
public interface CustomerRepository extends JpaRepository<Customer,Integer>{

}
