package com.cg.training.service;

import java.util.List;
import java.util.Optional;

import com.cg.training.model.Account;
import com.cg.training.model.Transaction;
import com.cg.training.wrapper.AccountWrapper;
import com.cg.training.wrapper.WithdrawDepositReq;

/**
 * @author aishwarya
 *
 */
public interface AccountService {

	/*** This method is used to create account
	 * @return new Account */
	 Account createAccount(AccountWrapper account);

	/*** This method is used to get details of all accounts
	 * @returns List of all Account's Details*/ 
	 List<Account> getAccountDetails();
	 
	 
	 /**
	 This method is used to get account details by id
	 * @return account details associated with one id
	 */
	 Optional<Account> getAccountDetailsById(Integer id);

	/**
	 * This method is used to withdraw amount  
	 * @return String message
	 */
	 String withdrawMoney(WithdrawDepositReq withdraw);

	/**
	 * This method is used to deposit amount 
	 * @return  String message
	 */
	String depositMoneyToAcc(WithdrawDepositReq deposit);
	
	
	/**
	 * This method is used to deposit amount to bank
	 * @return  String message
	 */
	String depositMoneyToBank(final WithdrawDepositReq deposit);
	
	/**
	 * @return list of all transactions in form of a report
	 */
	List<Transaction> viewTransReport();

}


