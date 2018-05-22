package com.cg.training.model;

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
public class Customer {

	/**
	 customer id 
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer customerId;
	
	/**
	 bank id 
	 */
	@NotNull
	@ManyToOne(targetEntity=Bank.class)
	Bank bankId;
	
	/**
	 customer name 
	 */
	@NotNull
	private String name;
	 
	/**
	 customer pin 
	 */
	@NotNull
	private int pin;
	
	
	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", bankId=" + bankId + ", name=" + name + ", pin=" + pin + "]";
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId( final Integer customerId) {
		this.customerId = customerId;
	}
	
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Customer(final int customerId,final  Bank bankId, final String name,final  int pin) {
		super();
		this.customerId = customerId;
		this.bankId=bankId; 
		this.name = name;
		this.pin = pin;
	}
	
	public Customer(final  Bank bankId, final String name,final  int pin) {
		super();
		
		this.bankId=bankId;
		this.name = name;
		this.pin = pin;
	}
	
	public void setBankId(final Bank bankId) {
		this.bankId = bankId;
	}
	public @NotNull Bank getBankId() {
		return bankId;
	}
	public String getName() {
		return name;
	}
	public void setName(final String name) {
		this.name = name;
	}
	public int getPin() {
		return pin;
	}
	public void setPin(final int pin) {
		this.pin = pin;
	}
	
	
}
