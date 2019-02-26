package com.yash.model;

import java.io.Serializable;


public class User implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	
	
	
	private Integer userId;
	
	
	private String name;
	
	
	private String userName;
	
	
	private String userPassword;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public User(Integer userId, String name, String userName, String userPassword) {
		super();
		this.userId = userId;
		this.name = name;
		this.userName = userName;
		this.userPassword = userPassword;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}