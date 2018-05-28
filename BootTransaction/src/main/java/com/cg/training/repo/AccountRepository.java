package com.cg.training.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cg.training.model.Account;

/**
 * @author aishwarya
 *
 */
/* provides connection to database to perform account related operations*/
public interface AccountRepository extends JpaRepository<Account, Integer>{

	@Query
	Optional<Account> findByAccountId(Integer accountId);

}
