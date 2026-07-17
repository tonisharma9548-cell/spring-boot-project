package com.ecommerce.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


import com.ecommerce.entity.Order;
import com.ecommerce.entity.User;
import com.ecommerce.service.OrderService;
import com.ecommerce.service.UserService;

@Controller
 @RequestMapping("/ecommerce/orders")
public class OrderController
{
     private final OrderService orderService;
     private final UserService userService;
	
	 public OrderController(OrderService orderService, UserService userService) {
		
		this.orderService = orderService;
		this.userService = userService;
	}

	 @PostMapping("/user/{userId}")
	 public ResponseEntity<Order> createOrder(@PathVariable Long userId , @RequestBody Order order)
	 {
		 User user = userService.getById(userId);
		 if(user==null)
			return ResponseEntity.notFound().build();
		 
		 order.setUser(user);
		 Order saved = orderService.createOrder(userId , order);
		 return ResponseEntity.status(201).body(saved);
	 }
	 
	 @DeleteMapping("/{id}")
	 public ResponseEntity<Order> deleteOrder(@PathVariable Long id)
	 {
		 if(!orderService.existsById(id))
			   ResponseEntity.notFound().build();
		 orderService.deleteOrderById(id);
		 return ResponseEntity.noContent().build();
	 }
}
