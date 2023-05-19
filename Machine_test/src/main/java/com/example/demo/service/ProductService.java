package com.example.demo.service;

import java.util.List;

import com.example.demo.module.Product;

public interface ProductService 
{
	Product addProduct(Product p);
	
	Product deleteProduct(Integer pid);
	
	Product updateProduct(Product p);
	
	List<Product> getAllProduct();
	
	Product getProductById(Integer pid);
	
	List<Product> getCategoryProductByid(Integer pid);

}
