package com.yash.service;

import java.util.List;

import com.yash.model.Product;

public interface SellerService {
	
	public List<Product> getAllProducts();

	public Product getProduct(int id);

	public String addProduct(Product product);

	public String updateProduct(Product product,int id);

	public String deleteProduct(int id);
}
