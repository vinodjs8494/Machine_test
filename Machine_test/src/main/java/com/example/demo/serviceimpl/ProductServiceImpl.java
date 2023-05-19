package com.example.demo.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.module.Product;
import com.example.demo.repo.Productrepo;
import com.example.demo.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService 
{

	@Autowired
	Productrepo repo;
	@Override
	public Product addProduct(Product p) {

		return repo.save(p);
	}

	@Override
	public Product deleteProduct(Integer pid) {
		Product p=repo.findById(pid).orElse(null);
		if(p!=null)
		{
			repo.deleteById(pid);
			return p;
		}
		else
		{
			throw new ResourceNotFoundException("Category","Id",pid);
		}
	}

	@Override
	public Product updateProduct(Product p) 
	{
		Product p1=repo.findById(p.getPid()).orElse(null);
		if(p1!=null)
		{
			p1.setPname(p.getPname());
			p1.setPcost(p.getPcost());
			p1.setPquantity(p.getPquantity());
			return repo.save(p1);
		}
		else
		{
			throw new ResourceNotFoundException("Product","Id",p1.getPid());
		}
	}

	@Override
	public List<Product> getAllProduct() 
	{

		return repo.findAll();
	}

	@Override
	public Product getProductById(Integer pid) 
	{
		return repo.findById(pid).orElse(null);
	}

	@Override
	public List<Product> getCategoryProductByid(Integer pid) {
		
		return repo.getCategoryProductByid(pid);
	}

	
}
