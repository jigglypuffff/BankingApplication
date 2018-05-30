package com.cg.training.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class BankDenomination {
	
	@Id
	private Integer id;
	@OneToOne(targetEntity = Bank.class)
	private Bank bank;
	
	private Integer noOfDenomination;
	
	@OneToOne(targetEntity = RefMoney.class)
	private Integer denomination;
	
	
	@Override
	public String toString() {
		return "BankDenomination [bank=" + bank + ", noOfDenomination=" + noOfDenomination + ", denomination="
				+ denomination + "]";
	}
	public BankDenomination() {
		super(); 
	}
	public BankDenomination(Bank bank, Integer noOfDenomination, Integer denomination) {
		super();
		this.bank = bank;
		this.noOfDenomination = noOfDenomination;
		this.denomination = denomination;
	}
	public Bank getbank() {
		return bank;
	}
	public void setbank(Bank bank) {
		this.bank = bank;
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
