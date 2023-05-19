package com.example.demo.serviceimpl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.module.Category;
import com.example.demo.repo.Categoryrepo;
import com.example.demo.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService
{

	@Autowired
	Categoryrepo repo;


	@Override
	public Category addCategory(Category c) 
	{

		return repo.save(c);
	}

	@Override
	public Category deleteCategory(Integer cid) 
	{
		Category c=repo.findById(cid).orElse(null);
		if(c!=null)
		{
			repo.deleteById(cid);
			return c;
		}
		else
		{
			throw new ResourceNotFoundException("Category","Id",cid);

		}
	}

	@Override
	public Category updateCategory(Category c) 
	{
		Category c1=repo.findById(c.getCid()).orElse(null);
		if(c1!=null)
		{
			c1.setCname(c.getCname());
			return repo.save(c1);
		}
		else
		{
			throw new ResourceNotFoundException("Category","Id",c1.getCid());

		}
	}


	@Override
	public Category getCategoryById(Integer cid)
	{

		return repo.findById(cid).orElse(null);
	}

	@Override
	public List<Category> getAllCategory() {

		return repo.findAll();
	}


}
