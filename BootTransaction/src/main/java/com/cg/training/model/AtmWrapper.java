package com.cg.training.model;

/**
 * @author aishwarya
 *
 */
public class AtmWrapper {

	/**
	 Bank Id 
	 */
	private Integer bankId;
	/**
	 Atm class reference 
	 */
	private ATM atm;
	public Integer getBankId() {
		return bankId;
	}
	public void setBankId(final Integer bankId) {
		this.bankId = bankId;
	}
	public ATM getAtm() {
		return atm;
	}
	public void setAtm(final ATM atm) {
		this.atm = atm;
	}
	
	
	
}
