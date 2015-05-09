package com.zerocchi.bean;

import java.io.Serializable;

public class OrderMenu implements Serializable {
	
	private int orderId;
	private int menuId;
	private int quantity;
	
	public OrderMenu(int orderId, int menuId, int quantity){
		this.setOrderId(orderId);
		this.setMenuId(menuId);
		this.setQuantity(quantity);
	}
	
	public OrderMenu(int menuId, int quantity){
		this.setMenuId(menuId);
		this.setQuantity(quantity);
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getMenuId() {
		return menuId;
	}

	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
