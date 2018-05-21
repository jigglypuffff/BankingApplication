package com.cg.training.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import javax.transaction.Transactional;

import org.hibernate.cfg.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.training.repo.AccountRepository;
import com.cg.training.repo.BankRepository;
import com.cg.training.repo.CustomerRepository;
import com.cg.training.repo.TransactionRepository;
import com.cg.training.wrapper.AccountWrapper;
import com.cg.training.wrapper.WithdrawDepositReq;
import com.cg.training.exception.BankException;
import com.cg.training.model.Account;
import com.cg.training.model.Bank;
import com.cg.training.model.Customer;
import com.cg.training.model.Transaction;

/**
 * @author aishwarya
 *
 */
@Service
public class AccountServiceImpl implements AccountService {

	/** Logger to log details */
	static final Logger log = Logger.getLogger(AccountService.class.getName());
	
	/*@Autowired
	Environment env;*/

	/** Reference of AccountRepository */
	@Autowired
	AccountRepository accRepo;
	/**
	 * CustomerRepository reference
	 */
	@Autowired
	CustomerRepository custRepo;
	/**
	 * BankRepository reference
	 */ 
	@Autowired
	BankRepository bankRepo;

	/**
	 bank Service reference 
	 */
	@Autowired
	BankServiceImpl bankSer;

	/**
	 Customer service reference 
	 */
	@Autowired
	CustomerServiceImpl custSer;  

	/**
	 * TransactionRepository reference
	 */
	@Autowired
	TransactionRepository trans;

	@Override
	public Account createAccount(final AccountWrapper account) {

		log.info("Withdraw Section");
		try {

			final Customer customer = custSer.getCustomerDetailById(account.getcId()).get();

			final Bank bank = bankSer.getBankDetailById(account.getbId()).get();

			final Account acc = new Account();

			acc.setCustomerId(customer);

			acc.setBankId(bank);

			final BigDecimal newAccAmount = account.getAmount();

			final BigDecimal oldBankAmt = bank.getAmount();

			final BigDecimal newBankAmt = oldBankAmt.add(newAccAmount);

			bank.setAmount(newBankAmt);

			return accRepo.save(acc);
		} catch (BankException e) {
			throw new BankException("id not found");
		}

	}

	@Transactional
	@Override
	public String withdrawMoney(final WithdrawDepositReq withdraw) {

		log.info("Create Account Section");

		final Integer bankid = withdraw.getBankId();
		Bank bank = bankSer.getBankDetailById(withdraw.getBankId()).get();

		try {
			final Integer accountId = withdraw.getAccount().getAccountId();

			final Optional<Account> acc = accRepo.findById(accountId);

			final Account account = acc.get();//// through account Id we fetched the account object

			final BigDecimal withdrawAmt = withdraw.getAmount();

			final BigDecimal accAmount = account.getAmount();

			final BigDecimal updatedAmount = accAmount.subtract(withdrawAmt);

			account.setAmount(updatedAmount);

			bank.setAmount(updatedAmount); 

			bankRepo.save(bank);

			accRepo.save(account);
			
			final Transaction trsansact = new Transaction(withdraw.getCustomerId(), accountId, withdrawAmt, "Withdraw");

			trans.save(trsansact);

			return "success";
		
		} catch (BankException e) {
			
			e.getMessage();
		}
		return "success";

	}

	@Override
	public List<Account> getAccountDetails() {

		log.info("View All Account Details");
		return accRepo.findAll();
	}

	@Transactional
	@Override
	public String depositMoneyToAcc(final WithdrawDepositReq deposit) {

		log.info("Deposit To Account Section");

		try {

			final Integer accountId = deposit.getAccount().getAccountId();

			final Optional<Account> acc = accRepo.findById(accountId);

			final Account account = acc.get(); // through account Id we fetched the account object

			final BigDecimal depAmount = deposit.getAmount();

			final BigDecimal accAmount = account.getAmount();

			final BigDecimal updatedamount = depAmount.add(accAmount);

			account.setAmount(updatedamount);

			accRepo.save(account);

			final Transaction trsansact = new Transaction(deposit.getCustomerId(), accountId, depAmount, "Deposit");

			trans.save(trsansact);

			depositMoneyToBank(deposit);

			return "success";
		} catch (BankException e) {
			throw new BankException("Id not found");
		}
	}

	@Override
	public String depositMoneyToBank(final WithdrawDepositReq deposit) {

		log.info("Deposit To Bank Section");
		try {
			final Optional<Bank> bankId = bankRepo.findById(deposit.getBankId());
			final Bank bank = bankId.get(); // through bank Id we fetched the bank object

			final Integer accountId = deposit.getAccount().getAccountId();

			final Optional<Account> accobj = accRepo.findById(accountId);

			final Account accountobj = accobj.get(); // through account Id we fetched the account object

			final BigDecimal depAmount = deposit.getAmount();

			final BigDecimal accAmount = accountobj.getAmount();

			final BigDecimal updatedamount = depAmount.add(accAmount);

			accountobj.setAmount(updatedamount);

			accRepo.save(accountobj);

			bank.setAmount(updatedamount);

			bankRepo.save(bank);

			return "success";
		} catch (BankException e) {
			throw new BankException("Id not found");
		}
	}

	@Override
	public List<Transaction> viewTransReport() {

		return trans.findAll();
	}
}
