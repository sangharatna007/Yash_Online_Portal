package com.yash.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.yash.model.Product;
import com.yash.service.SellerService;

@RestController
@RequestMapping("/seller")
public class SellerController {

	@Autowired
	private SellerService sellerService;

	@GetMapping("/product")
	public ResponseEntity<List<Product>> getProductList() {
		List<Product> product = sellerService.getAllProducts();
		if (product.isEmpty()) {
			return new ResponseEntity<List<Product>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Product>>(product, HttpStatus.OK);

	}

	@GetMapping("/product/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable int id) {
		Product product = sellerService.getProduct(id);
		if (product == null) {
			return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Product>(product, HttpStatus.OK);
	}

	@PostMapping(value = "/product")
	public ResponseEntity<Void> addProduct(@Valid @RequestBody Product product, UriComponentsBuilder ucBuilder) {
		if (null != product) {
			sellerService.addProduct(product);
			HttpHeaders headers = new HttpHeaders();
			headers.setLocation(ucBuilder.path("/product/{id}").buildAndExpand(product.getProduct_id()).toUri());
			return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
		} else {
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}

	}

	@PutMapping("/product/{id}")
	public ResponseEntity<Product> updateProduct(@RequestBody Product product, @PathVariable Integer id) {
		Product currentProduct = sellerService.getProduct(id);

		if (currentProduct == null) {
			return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
		}

		currentProduct.setProduct_name(product.getProduct_name());
		currentProduct.setProduct_price(product.getProduct_price());
		currentProduct.setProduct_quantity(product.getProduct_quantity());
		currentProduct.setCategory_id(product.getCategory_id());
		currentProduct.setUser_id(product.getUser_id());
		currentProduct.setStatus_flag(product.getStatus_flag());

		sellerService.updateProduct(currentProduct, id);
		return new ResponseEntity<Product>(currentProduct, HttpStatus.OK);
	}

	@DeleteMapping("/product/{id}")
	public ResponseEntity<Product> deleteProduct(@PathVariable int id) {
		Product product = sellerService.getProduct(id);
		if (product == null) {

			return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
		}

		sellerService.deleteProduct(id);
		return new ResponseEntity<Product>(HttpStatus.NO_CONTENT);
	}
}
