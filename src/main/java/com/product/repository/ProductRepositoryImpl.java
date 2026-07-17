package com.product.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.product.model.Product;

@Repository
public class ProductRepositoryImpl implements ProductRepository
{
    private Session session;
    private Transaction trn;
    public ProductRepositoryImpl(SessionFactory factory)
    {
    	session=factory.openSession();
    	trn = session.getTransaction();
    }
	
	public void persistProduct(Product product) 
	{
		trn.begin();
		session.persist(product);
		trn.commit();
		
	}


	public List<Product> findAll() 
	{
		Query<Product> query = session.createQuery("from Product", Product.class);
		return query.list();
	}

	
	public Product findById(int pid) {
		Product product = session.find(Product.class, pid);
		return product;
	}

	
	public void deleteRecord(Product product) 
	{
		trn.begin();
		session.remove(product);
		trn.commit();
	}


	public void updateRecord(Product productUpdate, Product productExisting) {
		trn.begin();
	    productExisting.setName(productUpdate.getName());
	    productExisting.setBrand(productUpdate.getBrand());
	    productExisting.setPrice(productUpdate.getPrice());
	    
		trn.commit();
	}

	
}
