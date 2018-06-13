/*package com.cg.training.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class AtmDenomination {

	@OneToOne(targetEntity = ATM.class)
	private ATM atmId;

	private Integer noOfDenomination;
	@Id
	private Integer denomination;

	@Override
	public String toString() {
		return "AtmDenomination [atmId=" + atmId + ", noOfDenomination=" + noOfDenomination + ", denomination="
				+ denomination + "]";
	}

	public AtmDenomination() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AtmDenomination(ATM atmId, Integer noOfDenomination, Integer denomination) {
		super();
		this.atmId = atmId;
		this.noOfDenomination = noOfDenomination;
		this.denomination = denomination;
	}

	public ATM getAtmId() {
		return atmId;
	}

	public void setAtmId(ATM atmId) {
		this.atmId = atmId;
	}

	public Integer getNoOfDenomination() {
		return noOfDenomination;
	}

	public void setNoOfDenomination(Integer noOfDenomination) {
		this.noOfDenomination = noOfDenomination;
	}

	public Integer getDenomination() {
		return denomination;
	}

	public void setDenomination(Integer denomination) {
		this.denomination = denomination;
	}
}
*/