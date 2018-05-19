package com.cg.training.model;

import java.math.BigDecimal;

/**
 * @author aishwarya
 *
 */
public class WithdrawDepositReq {

	/**
	 bank id 
	 */
	private Integer bankId;
	/**
	 amount 
	 */
	private BigDecimal amount;
	/**
	 account reference
	 */
	private Account account;
	/**
	 customer id 
	 */
	private Integer customerId;
	public Integer getBankId() {
		return bankId;
	}
	public void setBankId(final Integer bankId) {
		this.bankId = bankId;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(final BigDecimal amount) {
		this.amount = amount;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(final Account account) {
		this.account = account;
	}
	public Integer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(final Integer customerId) {
		this.customerId = customerId;
	}
	@Override
	public String toString() {
		return "AccWithdrawWrap [bankId=" + bankId + ", amount=" + amount + ", account=" + account + ", customerId="
				+ customerId + "]";
	}
	public WithdrawDepositReq(final Integer bankId,final BigDecimal amount, final Account account,final  Integer customerId) {
		super();
		this.bankId = bankId;
		this.amount = amount;
		this.account = account;
		this.customerId = customerId;
	}
	public WithdrawDepositReq() {
		super();
		// TODO Auto-generated constructor stub
	}

	


}
