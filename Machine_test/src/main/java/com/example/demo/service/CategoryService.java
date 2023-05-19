package com.example.demo.service;

import java.util.List;

import com.example.demo.module.Category;

public interface CategoryService 
{
	Category addCategory(Category c);
	
	Category deleteCategory(Integer cid);
	
	Category updateCategory(Category c);
	
	List<Category> getAllCategory();
	
	Category getCategoryById(Integer cid);
	
	
}
