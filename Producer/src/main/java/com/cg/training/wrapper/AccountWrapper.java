package com.cg.training.wrapper;

import java.math.BigDecimal;

/**
 * @author aishwarya
 *
 */
public class AccountWrapper {

	/**
	 amount
	 */
	private BigDecimal amount;
	/**
	 Bank id 
	 */
	private Integer bId;
	/**
	 Customer id
	 */ 
	private Integer cId;
	
	
	
	public AccountWrapper(BigDecimal amount, Integer bId, Integer cId) {
		super();
		this.amount = amount;
		this.bId = bId;
		this.cId = cId;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	
	public Integer getbId() {
		return bId;
	}
	public void setbId(final Integer bId) {
		this.bId = bId;
	}
	public Integer getcId() {
		return cId;
	}
	public void setcId(final Integer cId) {
		this.cId = cId;
	}
	@Override
	public String toString() {
		return "AccBankCust [ bId=" + bId + ", cId=" + cId + "]";
	}
	
	
	
	
	
}
