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
import com.example.demo.service.CategoryService;

@RestController
public class CategoryController 
{
	@Autowired
	CategoryService ser;
	
	@PostMapping("/addCategory")
	ResponseEntity<Category> addCategory(@RequestBody Category c)
	{
		return new ResponseEntity<Category>(ser.addCategory(c),HttpStatus.CREATED);
	}

	@DeleteMapping("/deleteCategory")
	ResponseEntity<Category> deleteCategory(@RequestParam Integer cid)
	{
		return new ResponseEntity<Category>(ser.deleteCategory(cid),HttpStatus.OK);
	}
	
	@GetMapping("/getAllCategory")
	ResponseEntity<List<Category>>getAllCategory( )
	{
		return new ResponseEntity<List<Category>>(ser.getAllCategory(),HttpStatus.OK);
	}


	@GetMapping("/getCategoryById")
	ResponseEntity<Category>getCategoryById(@RequestHeader Integer cid )
	{
		return new ResponseEntity<Category>(ser.getCategoryById(cid),HttpStatus.FOUND);
	}

	@PutMapping("/updateCategory")
	ResponseEntity<Category>updateProduct(@RequestBody Category c )
	{
		return new ResponseEntity<Category>(ser.updateCategory(c),HttpStatus.OK);
	}

}
