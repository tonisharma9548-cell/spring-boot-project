package com.product.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.product.model.Product;
import com.product.repository.ProductRepository;

@Service
public  class ProductServiceImpl implements ProductService
{

	private ProductRepository productRepository;
	{
		
	}
	public ProductServiceImpl(ProductRepository productRepository) {
		
		this.productRepository = productRepository;
	}
	
	public void saveProduct(Product product) 
	{
		productRepository.persistProduct(product);
		
	}

	public List<Product> getProducts() 
	{
		return productRepository.findAll();
	}


	public Product getProduct(int pid)
	{
		return productRepository.findById(pid);
		
	}

	public void deleteProduct(int pid)
	{
		 Product product= productRepository.findById(pid);
		 productRepository.deleteRecord(product);
				
	}


	public void updateRecord(Product productUpdate) {
		 Product productExisting= productRepository.findById(productUpdate.getPid());
		 productRepository.updateRecord(productUpdate, productExisting);
		
	}

   
}
