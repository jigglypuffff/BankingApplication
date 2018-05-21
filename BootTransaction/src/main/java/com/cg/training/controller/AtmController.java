package com.cg.training.controller;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cg.training.model.ATM;
import com.cg.training.service.AtmService;
import com.cg.training.wrapper.AtmRequest;
import com.cg.training.wrapper.AtmWrapper;


/**
 * @author aishwarya
 *
 */
@RestController
@RequestMapping("/atm")
public class AtmController {
	static final Logger log =Logger.getLogger("myfirstlogger");
	
	@Autowired
	AtmService atmSer;

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ATM addAtm(final @RequestBody AtmWrapper atm)
	{
		log.info("Add atm");
		return atmSer.createAtm(atm);
		
	}
	
	
	@RequestMapping(value = "/addMoney", method = RequestMethod.POST)
	public String addMoneyFromBank(final AtmRequest req)
	{
		log.info("Add money from bank");
		atmSer.addMoneyFromBank(req);
		return "Successfully added money from Bank !";
	}
	

	@RequestMapping(value = "/withdrawMoney", method = RequestMethod.POST)
	public String withdrawMoneyFromAtm(final AtmRequest req)
	{
		log.info("Withdraw money from atm");
		atmSer. withdrawMoney(req);
		return "Successfully withdrawn money from Atm !";
	}
	

}
