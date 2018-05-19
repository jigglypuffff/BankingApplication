package com.cg.training.service;

import com.cg.training.model.ATM;
import com.cg.training.model.AtmRequest;
import com.cg.training.model.AtmWrapper;

/**
 * @author aishwarya
 *
 */
public interface AtmService {

	 /**
	 * @param atm
	 * @return atm
	 */
	ATM createAtm(AtmWrapper atm);
	
	 /**
	 * @return string messsage
	 */
	 String addMoneyFromBank( AtmRequest req);
	
	 /**
	 * @return string message
	 */
	String withdrawMoney(AtmRequest req);
}
