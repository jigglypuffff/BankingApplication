package com.cg.training.model;

/**
 * @author aishwarya
 *
 */
public class AccountWrapper {

	/**
	 Account reference
	 */
	private Account account;
	/**
	 Bank id 
	 */
	private Integer bId;
	/**
	 Customer id
	 */
	private Integer cId;
	public Account getAccount() {
		return account;
	}
	public void setAccount(final Account account) {
		this.account = account;
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
		return "AccBankCust [account=" + account + ", bId=" + bId + ", cId=" + cId + "]";
	}
	
	
	
	
	
}
