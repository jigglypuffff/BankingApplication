package com.cg.training.service;

import java.util.List;

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

	/*** This method is used to create account
	 * @returns List of all Account's Details*/ 
	 List<Account> getAccountDetails();

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


