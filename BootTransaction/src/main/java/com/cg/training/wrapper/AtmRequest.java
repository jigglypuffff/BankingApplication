package com.cg.training.wrapper;

import java.math.BigDecimal;

import com.cg.training.model.ATM;

/**
 * @author aishwarya
 *
 */
public class AtmRequest {

	/**
	 * Amount
	 */
	BigDecimal amount;
	/**
	 * Atm reference
	 */
	ATM atm;
	/**
	 * Bank id
	 */
	Integer bId;

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public ATM getAtm() {
		return atm;
	}

	public void setAtm(ATM atm) {
		this.atm = atm;
	}

	public Integer getbId() {
		return bId;
	}

	public void setbId(Integer bId) {
		this.bId = bId;
	}
}
