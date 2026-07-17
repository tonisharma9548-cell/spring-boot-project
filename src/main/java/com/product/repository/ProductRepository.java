package com.product.repository;

import java.util.List;

import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.stereotype.Repository;

import com.product.model.Product;

public interface ProductRepository 
{
	void persistProduct(Product product);
     List<Product> findAll();
	 Product findById(int pid);
	
	 void deleteRecord(Product product);
	
	 void updateRecord(Product productUpdate, Product productExisting);
	
	
	
	


}
