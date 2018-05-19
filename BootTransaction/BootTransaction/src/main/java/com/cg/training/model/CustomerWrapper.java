package com.cg.training.model;

/**
 * @author aishwarya
 *
 */
public class CustomerWrapper {
	
	/**
	 bank id 
	 */
	private Integer  bId;
	/**
	 Customer reference 
	 */
	private Customer customer;
	
	
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(final Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "CustBank [id=" + bId + ", customer=" + customer + "]";
	}

	public Integer getbId() {
		return bId;
	}

	public void setbId(final Integer bId) {
		this.bId = bId;
	}
	
	
}
