package com.cg.training.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author aishwarya
 *
 */
@Entity
public class Bank {
	/**
	 bank id 
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer bankId;
	/**
	 amount 
	 */
	private BigDecimal amount;
 
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

	@Override
	public String toString() {
		return "Bank [bankId=" + bankId + ", amount=" + amount + "]";
	}

	public Bank(final Integer bankId, final BigDecimal amount) {
		super();
		this.bankId = bankId;
		this.amount = amount;
	}
	
	
	 @Override
	    public boolean equals(Object obj)
	    {
	         
	    // checking if both the object references are 
	    // referring to the same object.
	    if(this == obj)
	            return true;
	         
	        // it checks if the argument is of the 
	        // type Geek by comparing the classes 
	        // of the passed argument and this object.
	        // if(!(obj instanceof Geek)) return false; ---> avoid.
	        if(obj == null || obj.getClass()!= this.getClass())
	            return false;
	         
	        // type casting of the argument. 
	        Bank bank = (Bank) obj;
	         
	        // comparing the state of argument with 
	        // the state of 'this' Object.
	        return (bank.bankId == this.bankId && bank.amount == this.amount);
	    }
	     

	public Bank() {
		super();

	}

	public Bank(final Integer bankId) {
		super();
		this.bankId = bankId;
	}

}
