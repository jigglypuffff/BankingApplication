package com.cg.training.controller;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cg.training.model.ATM;
import com.cg.training.model.AtmWrapper;
import com.cg.training.service.AtmService;


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
		
	}}
