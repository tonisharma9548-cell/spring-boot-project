package com.product.service;

import java.util.List;

import com.product.model.Product;
import com.product.repository.ProductRepository;


public interface ProductService 
{

	 void saveProduct(Product product) ;

	 List<Product> getProducts();

	 Product getProduct(int pid);

	 void deleteProduct(int pid);

	 void updateRecord(Product productUpdate);
    



	
}
