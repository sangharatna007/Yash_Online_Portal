package com.yash.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.yash.mapper.SellerRowMapper;
import com.yash.model.Product;



@Repository
public class SellerDaoImpl implements SellerDao{

	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;  
	
	public NamedParameterJdbcTemplate getNamedParameterJdbcTemplate() {
		return namedParameterJdbcTemplate;
	}
	
	
	public List<Product> getAllProducts() {
		String sql = "SELECT PRODUCT_ID, PRODUCT_NAME, PRODUCT_PRICE, PRODUCT_QUANTITY,CATEGORY_ID,USER_ID,STATUS_FLAG FROM PRODUCT_MASTER";
        List<Product> lstProducts  = getNamedParameterJdbcTemplate().query(sql,
                new SellerRowMapper());
        return lstProducts;
	}

	public Product getProduct(int id) {
		
		 String sql = "SELECT PRODUCT_ID,PRODUCT_NAME, PRODUCT_PRICE, PRODUCT_QUANTITY,CATEGORY_ID,USER_ID,STATUS_FLAG FROM PRODUCT_MASTER WHERE PRODUCT_ID = :id";
	        SqlParameterSource namedParameters = new MapSqlParameterSource("id", id);
	        Product product = getNamedParameterJdbcTemplate().queryForObject(sql,namedParameters,new SellerRowMapper());
	        return product;
		
		
	}
	
	public String addProduct(Product product) {
		
		String sql = "INSERT INTO PRODUCT_MASTER(PRODUCT_NAME, PRODUCT_PRICE, PRODUCT_QUANTITY,CATEGORY_ID,USER_ID,STATUS_FLAG) VALUES( :product_name, :product_quantity, :product_price ,:category_id,:user_id,:status_flag)";
        SqlParameterSource namedParameters = new MapSqlParameterSource()
        .addValue("product_name", product.getProduct_name())
        .addValue("product_quantity", product.getProduct_quantity())
        .addValue("product_price", product.getProduct_price())
        .addValue("category_id",product.getCategory_id())
        .addValue("user_id", product.getUser_id())
        .addValue("status_flag", product.getStatus_flag());
        
 
        int returnValue = getNamedParameterJdbcTemplate().update(
                sql,
                namedParameters);
 
        if(1 == returnValue)
            return "Product creation is SUCCESS";
        else
            return "Product creation is FAILURE";
		}
       
		
	
	
	public String updateProduct(Product product,int id) {
		
		String sql = "UPDATE PRODUCT_MASTER SET PRODUCT_NAME = :product_name, PRODUCT_QUANTITY = :product_quantity, PRODUCT_PRICE = :product_price,CATEGORY_ID = :category_id, USER_ID = :user_id, STATUS_FLAG = :status_flag WHERE PRODUCT_ID = :product_id";
        SqlParameterSource namedParameters = new MapSqlParameterSource()
        		.addValue("product_name", product.getProduct_name())
                .addValue("product_quantity", product.getProduct_quantity())
                .addValue("product_price", product.getProduct_price())
                .addValue("category_id",product.getCategory_id())
                .addValue("user_id", product.getUser_id())
                .addValue("status_flag", product.getStatus_flag())
                .addValue("product_id", id);
                
 
        int returnValue = getNamedParameterJdbcTemplate().update(
                sql,
                namedParameters);
 
        if(1 == returnValue)
            return "Product updation is SUCCESS";
        else
            return "Product updation is FAILURE";
		
		
		
	}

	public String deleteProduct(int id) {
		
		String sql = "DELETE FROM PRODUCT_MASTER WHERE PRODUCT_ID =:product_id ";
        SqlParameterSource namedParameters = new MapSqlParameterSource("product_id", id);
 
        int returnValue = getNamedParameterJdbcTemplate().update(
                sql,
                namedParameters);
 
        if(1 == returnValue)
            return "Product deletion is SUCCESS";
        else
            return "Product deletion is FAILURE";
	}

	
		
	}

