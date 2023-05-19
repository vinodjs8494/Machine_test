package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.module.Category;

public interface Categoryrepo extends JpaRepository<Category, Integer>
{
	@Query(value="select * from Category",nativeQuery=true)
	List<Category> findAllProducts();
	
	
}
