package com.cg.training.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cg.training.model.Bank;
import com.cg.training.service.BankService;
/**
 * @author aishwarya
 *
 */
@RestController
@RequestMapping("/bank")
public class BankController {

	/**
	 BankService reference 
	 */
	@Autowired
	BankService bankSer;

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public void addBank(final @RequestBody Bank bank) {
		bankSer.createBank(bank);
	}

	@RequestMapping(value = "/view", method = RequestMethod.GET)
	public List<Bank> showBankDetails() {
		return bankSer.getBankDetails();
	}
}
 