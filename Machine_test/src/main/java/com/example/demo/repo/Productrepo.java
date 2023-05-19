package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.module.Product;

public interface Productrepo extends JpaRepository<Product, Integer>
{

	@Query(value="select * from Product",nativeQuery=true)
	List<Product> findAllProduct();
	
	@Query(value="select product.pid,product.pname,product.pcost,product.pquantity,category.cid,category.cname from product,category where product.products_cid=category.cid and product.pid=?1",nativeQuery = true)
	List<Product> getCategoryProductByid(Integer pid);
}
