package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.module.Category;
import com.example.demo.module.Product;
import com.example.demo.service.ProductService;

@RestController
public class ProductController 
{

	@Autowired
	ProductService ser;
	
	@PostMapping("/addProduct")
	ResponseEntity<Product> addProduct(@RequestBody Product p)
	{
		return new ResponseEntity<Product>(ser.addProduct(p),HttpStatus.CREATED);
	}

	@DeleteMapping("/deleteProduct")
	ResponseEntity<Product> deleteProduct(@RequestParam Integer pid)
	{
		return new ResponseEntity<Product>(ser.deleteProduct(pid),HttpStatus.OK);
	}
	
	@GetMapping("/getAllProduct")
	ResponseEntity<List<Product>>getAllProducts( )
	{
		return new ResponseEntity<List<Product>>(ser.getAllProduct(),HttpStatus.OK);
	}

	@GetMapping("/getProductById")
	ResponseEntity<Product>getProductById(@RequestHeader Integer pid )
	{
		return new ResponseEntity<Product>(ser.getProductById(pid),HttpStatus.FOUND);
	}

	@PutMapping("/updateProduct")
	ResponseEntity<Product>updateProduct(@RequestBody Product p )
	{
		return new ResponseEntity<Product>(ser.updateProduct(p),HttpStatus.OK);
	}

	@GetMapping("/getCategoryProductById")
	ResponseEntity<List<Product>>getCategoryProductById(@RequestHeader Integer pid )
	{
		return new ResponseEntity<List<Product>>(ser.getCategoryProductByid(pid),HttpStatus.FOUND);
	}

		
}
