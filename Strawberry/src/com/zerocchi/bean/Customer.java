package com.zerocchi.bean;

import java.io.Serializable;

public class Customer implements Serializable {


	private static final long serialVersionUID = -7745282967589073538L;

	private int customerId;
	private String customerName;
	private String customerAddress;
	private int customerPhoneNo;
	private String customerEmail;
	
	public Customer() {}
	
	public int getCustomerId() {
		return customerId;
	}
	
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	
	public String getCustomerName() {
		return customerName;
	}
	
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	
	public String getCustomerAddress() {
		return customerAddress;
	}
	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}
	
	public int getCustomerPhoneNo() {
		return customerPhoneNo;
	}
	
	public void setCustomerPhoneNo(int customerPhoneNo) {
		this.customerPhoneNo = customerPhoneNo;
	}
	
	public String getCustomerEmail() {
		return customerEmail;
	}
	
	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}
	
	
}
