package com.yash.model;

import java.io.Serializable;


public class Category implements Serializable {

	
	private static final long serialVersionUID = -1864198348558983648L;

	
	private int categoryId;
	
	
	private String categoryType;

	

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryType() {
		return categoryType;
	}

	public void setCategoryType(String categoryType) {
		this.categoryType = categoryType;
	}
		
}
