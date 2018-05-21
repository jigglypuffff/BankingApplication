package com.cg.training.controller;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cg.training.model.Account;
import com.cg.training.service.AccountService;
import com.cg.training.wrapper.AccountWrapper;
import com.cg.training.wrapper.WithdrawDepositReq;

/**
 * @author aishwarya
 *
 */
@RestController
@RequestMapping("/account")
public class AccountController {
	
	Logger log =Logger.getLogger(AccountController.class.getName());
	 
	/**
	 Reference of accountService 
	 */
	@Autowired
	AccountService accountSer;

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public Account addAccount(final @RequestBody AccountWrapper account) {
		log.info("Create acount");
		return accountSer.createAccount(account);	
	}

	@RequestMapping(value = "/view", method = RequestMethod.GET)
	public List<Account> showAccDetails() {
		log.info("Show acount");
		return accountSer.getAccountDetails();
	}

	@RequestMapping(value = "/deposit", method = RequestMethod.POST)
	public String depositMoneyToAcc(final @RequestBody WithdrawDepositReq deposit) {
		log.info("deposit amount");
		return accountSer.depositMoneyToAcc(deposit);

	}
	
	@RequestMapping(value = "/withdraw", method = RequestMethod.POST)
	public String withdrawAmount(final @RequestBody WithdrawDepositReq wrap) {
		log.info("withdraw amount");
		return accountSer.withdrawMoney(wrap);

	}
}
