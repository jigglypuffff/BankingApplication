package com.cg.training.wrapper;

import com.cg.training.model.BaseEntity;
import com.cg.training.model.Customer;

/**
 * @author aishwarya
 *
 */
public class CustomerWrapper extends BaseEntity {
	
	/**
	 bank id 
	 */
	private Integer  bId;
	/**
	 Customer reference 
	 */
	private Customer customer;
	
	
	public CustomerWrapper(Integer bId, Customer customer) {
		super();
		this.bId = bId;
		this.customer = customer;
	}

	public Customer getCustomer() {
		return customer;
	}

	public CustomerWrapper() {
		super();
		// TODO Auto-generated constructor stub
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
