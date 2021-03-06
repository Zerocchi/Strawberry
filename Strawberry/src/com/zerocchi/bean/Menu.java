package com.zerocchi.bean;

import java.io.Serializable;

// Menu bean

public class Menu implements Serializable {

	private static final long serialVersionUID = -8072555192585991919L;

	private int menuId;
	private String menuName;
	private double menuPrice;
	private int quantity;
	
	public Menu(String menuName, double menuPrice) {
		this.setMenuName(menuName);
		this.setMenuPrice(menuPrice);
	}
	
	public Menu(int menuId, int quantity) {
		this.setMenuId(menuId);
		this.setQuantity(quantity);
	}
	
	public Menu() {
		setMenuName("");
		setMenuPrice(0);
	}

	public double getMenuPrice() {
		return menuPrice;
	}

	public void setMenuPrice(double menuPrice) {
		if(menuPrice > 0)
			this.menuPrice = menuPrice;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
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
