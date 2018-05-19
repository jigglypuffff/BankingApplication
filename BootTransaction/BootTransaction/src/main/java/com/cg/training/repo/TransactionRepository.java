package com.cg.training.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.training.model.Transaction;

/**
 * @author aishwarya
 *
 */
/* provides connection to database to perform transaction related operations*/
public interface TransactionRepository extends JpaRepository<Transaction, Integer>{

}
