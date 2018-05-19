package com.cg.training.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.training.model.Account;

/**
 * @author aishwarya
 *
 */
/* provides connection to database to perform account related operations*/
public interface AccountRepository extends JpaRepository<Account, Integer>{

}
