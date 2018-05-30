package com.cg.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.training.model.RefMoney;
import com.cg.training.repo.RefMoneyRepo;

@Service
public class RefServiceImpl implements RefService{
	
	@Autowired
	RefMoneyRepo refRepo;
	
	
	@Override
	public List<RefMoney> viewAll() {
		
		List<RefMoney> list = refRepo.findAll() ;
		
		
		
		RefMoney ref = new RefMoney(50);
		
		RefMoney ref1 = new RefMoney(100);
		
		RefMoney ref2 = new RefMoney(200);
	
		RefMoney ref3 = new RefMoney(500);
		
		refRepo.save(ref);
		
		refRepo.save(ref1);
		refRepo.save(ref2);
		refRepo.save(ref3);
		 
		
		
		return list;
	}

}
