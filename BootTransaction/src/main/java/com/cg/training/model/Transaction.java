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
public class Transaction {

	/**
	 transaction id 
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer transactionId;

	/**
	 customer id 
	 */
	private Integer customerId;

	/**
	 account id
	 */
	private Integer accountId;

	/**
	 amount
	 */
	private BigDecimal amount;

	/**
	 transaction type 
	 */
	private String transactionType;

	public Integer getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(final Integer transactionId) {
		this.transactionId = transactionId;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(final Integer customerId) {
		this.customerId = customerId;
	}

	public Integer getAccountId() {
		return accountId;
	}

	public void setAccountId(final Integer accountId) {
		this.accountId = accountId;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(final BigDecimal amount) {
		this.amount = amount;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(final String transactionType) {
		this.transactionType = transactionType;
	}

	@Override
	public String toString() {
		return "Transaction [transactionId=" + transactionId + ", customerId=" + customerId + ", accountId=" + accountId
				+ ", amount=" + amount + ", transactionType=" + transactionType + "]";
	}

	public Transaction(final Integer customerId,final  Integer accountId,final  BigDecimal amount,final  String transactionType) {
		super();

		this.customerId = customerId;
		this.accountId = accountId;
		this.amount = amount;
		this.transactionType = transactionType;
	}

	public Transaction() {
		super();
		// TODO Auto-generated constructor stub
	}

}
