package com.cg.training.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class RefMoney {

	@Id
	private Integer denomination;

	@Override
	public String toString() {
		return "RefMoney [denomination=" + denomination + "]";
	}

	public RefMoney() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RefMoney(Integer denomination) { 
		super();
		this.denomination = denomination;
	}

	public Integer getDenomination() {
		return denomination;
	}

	
}
