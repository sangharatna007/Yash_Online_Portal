package com.yash.model;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

public class Product implements Serializable{

	
	private static final long serialVersionUID = 1L;

	@NotNull(message="Id should not be null")
	private Integer product_id;

	@NotNull(message="Product name should not be null")
	private String product_name;

	@NotNull(message="Product quantity should not be null")
	private Integer product_quantity;

	@NotNull(message="Product price should not be null")
	private Double product_price;

	@NotNull(message="Category id should not be null")
	private Integer category_id;

	@NotNull(message="User Id should not be null")
	private Integer user_id;
	
	@NotNull(message="Status Flag should not be null")
	private Integer status_flag;

	public Integer getProduct_id() {
		return product_id;
	}

	public void setProduct_id(Integer product_id) {
		this.product_id = product_id;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public Integer getProduct_quantity() {
		return product_quantity;
	}

	public void setProduct_quantity(Integer product_quantity) {
		this.product_quantity = product_quantity;
	}

	public Double getProduct_price() {
		return product_price;
	}

	public void setProduct_price(Double product_price) {
		this.product_price = product_price;
	}

	public Integer getCategory_id() {
		return category_id;
	}

	public void setCategory_id(Integer category_id) {
		this.category_id = category_id;
	}

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public Integer getStatus_flag() {
		return status_flag;
	}

	public void setStatus_flag(Integer status_flag) {
		this.status_flag = status_flag;
	}
	public Product(Integer product_id, String product_name, Integer product_quantity, Double product_price,Integer category_id,Integer user_id,Integer status_flag) {
		super();
		this.product_id = product_id;
		this.product_name = product_name;
		this.product_quantity = product_quantity;
		this.product_price = product_price;
		this.category_id = category_id;
		this.user_id = user_id;
		this.status_flag = status_flag;
	}

	public Product() {
		super();
		
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((category_id == null) ? 0 : category_id.hashCode());
		result = prime * result + ((product_id == null) ? 0 : product_id.hashCode());
		result = prime * result + ((product_name == null) ? 0 : product_name.hashCode());
		result = prime * result + ((product_quantity == null) ? 0 : product_quantity.hashCode());
		result = prime * result + ((product_price == null) ? 0 : product_price.hashCode());
		result = prime * result + ((user_id == null) ? 0 : user_id.hashCode());
		result = prime * result + ((status_flag == null) ? 0 : status_flag.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (category_id == null) {
			if (other.category_id != null)
				return false;
		} else if (!category_id.equals(other.category_id))
			return false;
		if (product_id == null) {
			if (other.product_id != null)
				return false;
		} else if (!product_id.equals(other.product_id))
			return false;
		if (product_name == null) {
			if (other.product_name != null)
				return false;
		} else if (!product_name.equals(other.product_name))
			return false;
		if (product_price == null) {
			if (other.product_price != null)
				return false;
		} else if (!product_price.equals(other.product_price))
			return false;
		if (product_quantity == null) {
			if (other.product_quantity != null)
				return false;
		} else if (!product_quantity.equals(other.product_quantity))
			return false;
		if (status_flag == null) {
			if (other.status_flag != null)
				return false;
		} else if (!status_flag.equals(other.status_flag))
			return false;
		if (user_id == null) {
			if (other.user_id != null)
				return false;
		} else if (!user_id.equals(other.user_id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Product [product_id=" + product_id + ", product_name=" + product_name + ", product_quantity="
				+ product_quantity + ", product_price=" + product_price + ", category_id=" + category_id + ", user_id="
				+ user_id + ", status_flag=" + status_flag + "]";
	}

}
