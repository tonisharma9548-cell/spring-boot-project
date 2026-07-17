package com.ecommerce.service;

import com.ecommerce.entity.Order;

public interface OrderService 
{
     Order createOrder(Long userId, Order order);

	 boolean existsById(Long id);

	 void deleteOrderById(Long id);

}
