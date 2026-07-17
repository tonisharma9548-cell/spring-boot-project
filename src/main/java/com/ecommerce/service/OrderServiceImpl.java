package com.ecommerce.service;

import org.springframework.stereotype.Service;

import com.ecommerce.entity.Order;
import com.ecommerce.repository.OrderRepository;
import com.ecommerce.repository.UserRepository;

@Service
public class OrderServiceImpl implements OrderService

{
    private OrderRepository orderRepository;

	public OrderServiceImpl(OrderRepository orderRepository) {
	
		this.orderRepository = orderRepository;
	}


	public Order createOrder(Long userId, Order order) {
		
		return orderRepository.save(order);
	}


	public boolean existsById(Long id) {
	
		return orderRepository.existsById(id);
	}

public void deleteOrderById(Long id)
	{
	    orderRepository.deleteById(id);
	}
    
    
}
