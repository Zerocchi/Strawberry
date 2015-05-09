package com.zerocchi.bean;

import java.io.Serializable;

public class User implements Serializable {

	private static final long serialVersionUID = 9193531751810206646L;
	
	private int userId;
	private String userName;
	private String userPass;
	private String userAccess;
	
	public User(){}
	
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPass() {
		return userPass;
	}

	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}

	public String getUserAccess() {
		return userAccess;
	}

	public void setUserAccess(String userAccess) {
		this.userAccess = userAccess;
	}

	
	
}
