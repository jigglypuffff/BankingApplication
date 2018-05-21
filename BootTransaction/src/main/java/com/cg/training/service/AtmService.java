package com.cg.training.service;

import java.util.Optional;

import com.cg.training.model.ATM;
import com.cg.training.wrapper.AtmRequest;
import com.cg.training.wrapper.AtmWrapper;

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
	String addMoneyFromBank(AtmRequest req);

	/**
	 * @return string message
	 */
	String withdrawMoney(AtmRequest req);

	Optional<ATM> getAtmDetailById(final Integer id);

}
