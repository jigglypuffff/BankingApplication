package com.cg.training.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * @author aishwarya
 *
 */
@Entity
public class ATM {
	
	/**
	 Atm id 
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int atmId;
	/**
	 Amount 
	 */
	private BigDecimal amount;
	
	/**
	 Bank id 
	 */
	@ManyToOne(targetEntity=Bank.class)
	private Bank bankId;

	@Override
	public String toString() {
		return "ATM [atmId=" + atmId + ", amount=" + amount + ", bankId=" + bankId + "]";
	}

	public ATM() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ATM(final int atmId, final BigDecimal amount,final Bank bankId) {
		super();
		this.atmId = atmId;
		this.amount = amount;
		this.bankId = bankId;
	}

	public int getatmId() {
		return atmId;
	}

	public void setatmId(final int atmId) {
		this.atmId = atmId;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(final BigDecimal amount) {
		this.amount = amount;
	}

	public Bank getBankId() {
		return bankId;
	}

	public void setBankId(final Bank bankId) {
		this.bankId = bankId;
	}
	
	
	
	
}
