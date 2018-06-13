package com.cg.training.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cg.training.model.RefMoney;
import com.cg.training.service.RefService;

@RestController@RequestMapping(value= "/refMoney")
public class RefController {
	
	@Autowired 
	RefService refService;
	
	@RequestMapping(value= "/showAll" , method = RequestMethod.GET)
	public List<RefMoney> viewDenominations()
	{
		return refService.viewAll();		
	}
	

}
