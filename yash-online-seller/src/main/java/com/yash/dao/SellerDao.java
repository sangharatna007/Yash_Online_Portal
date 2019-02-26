package com.yash.dao;

import java.util.List;

import com.yash.model.Product;


public interface SellerDao {
	public List<Product> getAllProducts();
	public Product getProduct(int id);
	public String addProduct(Product product);
	public String updateProduct(Product product,int id);
	public String deleteProduct(int id);
}
