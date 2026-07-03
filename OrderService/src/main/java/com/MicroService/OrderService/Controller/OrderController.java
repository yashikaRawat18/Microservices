package com.MicroService.OrderService.Controller;

import java.util.List;

import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.MicroService.OrderService.Model.Order;
import com.MicroService.OrderService.Service.OrderService;

@RestController
@RequestMapping("/api/orders")
public class OrderController{
	
	@Autowired
	private OrderService orderService;
	
	@PostMapping
	public ResponseEntity<Order> createOrder(@RequestBody Order order){
		String name=SecurityContextHolder.getContext().getAuthentication().getName();
		return ResponseEntity.ok(orderService.createOrder(order, name));
	}
	
	@GetMapping
	public ResponseEntity<List<Order>> getMyOrders(){
		String name = SecurityContextHolder.getContext().getAuthentication().getName();
		return ResponseEntity.ok(orderService.getMyOrders(name));
	}
	@DeleteMapping("/{id}")
	public String orderDelete( @PathVariable Integer id){
		String name=SecurityContextHolder.getContext().getAuthentication().getName();
		return orderService.orderDelete(id, name);
		
	}
	{
		
	}
}
