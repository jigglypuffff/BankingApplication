package com.cg.training.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

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
	private Integer atmId;
	
	public Integer getAtmId() {
		return atmId;
	}

	public void setAtmId(Integer atmId) {
		this.atmId = atmId;
	}

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

	public ATM( final BigDecimal amount,final Bank bankId) {
		super();
		
		this.amount = amount;
		this.bankId = bankId;
	}

	public Integer getatmId() {
		return atmId;
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
