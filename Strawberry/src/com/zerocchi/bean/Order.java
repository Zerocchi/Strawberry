package com.zerocchi.bean;

import java.io.Serializable;

public class Order implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8240441394311975027L;
	
	private int orderId;
	private int userId;
	private String description;
	private int status; // 0 for not ready, 1 for OK
	private int randomNum;

	public Order(){}
	
	public Order(int orderId, int userId, String description){
		this.setOrderId(orderId);
		this.setUserId(userId);
		this.setDescription(description);
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getRandomNum() {
		return randomNum;
	}

	public void setRandomNum(int randomNum) {
		this.randomNum = randomNum;
	}
	
}
