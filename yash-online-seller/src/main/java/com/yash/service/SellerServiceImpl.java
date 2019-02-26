package com.yash.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yash.dao.SellerDao;
import com.yash.model.Product;

@Service("sellerService")
public class SellerServiceImpl implements SellerService{
	
	@Autowired
	private SellerDao sellerDao;
	
	
	public List<Product> getAllProducts() {
		return sellerDao.getAllProducts();
	}
	
	public Product getProduct(int id) {
		return sellerDao.getProduct(id);
	}
	
	public String addProduct(Product product) {
		return sellerDao.addProduct(product);
	}
	
	public String updateProduct(Product product,int id) {
		return sellerDao.updateProduct(product,id);
		
	}
	public String deleteProduct(int id) {
		return sellerDao.deleteProduct(id);
		
	}

}
