package com.cg.training.wrapper;

import java.math.BigDecimal;

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
	private BigDecimal amount;
	
	
	
	public AtmWrapper(Integer bankId, BigDecimal amount) {
		super();
		this.bankId = bankId;
		this.amount = amount;
	}
	public Integer getBankId() {
		return bankId;
	}
	public void setBankId(final Integer bankId) {
		this.bankId = bankId;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	
	
	
	
}
