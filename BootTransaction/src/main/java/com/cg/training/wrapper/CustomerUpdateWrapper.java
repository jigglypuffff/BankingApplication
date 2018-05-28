package com.cg.training.wrapper;

public class CustomerUpdateWrapper {

	private Integer customerId;
	private Integer userId;
	private String customerName;
	public Integer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	@Override
	public String toString() {
		return "CustomerUpdateWrapper [customerId=" + customerId + ", userId=" + userId + ", customerName="
				+ customerName + "]";
	}
	public CustomerUpdateWrapper() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CustomerUpdateWrapper(Integer customerId, Integer userId, String customerName) {
		super();
		this.customerId = customerId;
		this.userId = userId;
		this.customerName = customerName;
	}
	
	
	
	
}
