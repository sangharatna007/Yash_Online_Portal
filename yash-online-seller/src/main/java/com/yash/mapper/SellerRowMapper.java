package com.yash.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.yash.model.Product;

public class SellerRowMapper implements RowMapper<Product>{

	public Product mapRow(ResultSet resultSet, int rowNumber) throws SQLException {
		Product product = new Product();
		product.setProduct_id(resultSet.getInt("PRODUCT_ID"));
		product.setProduct_name(resultSet.getString("PRODUCT_NAME"));
		product.setProduct_price(resultSet.getDouble("PRODUCT_PRICE"));
		product.setProduct_quantity(resultSet.getInt("PRODUCT_QUANTITY"));
		product.setCategory_id(resultSet.getInt("CATEGORY_ID"));
		product.setUser_id(resultSet.getInt("USER_ID"));
		product.setStatus_flag(resultSet.getInt("STATUS_FLAg"));
        return product;
    }
}
