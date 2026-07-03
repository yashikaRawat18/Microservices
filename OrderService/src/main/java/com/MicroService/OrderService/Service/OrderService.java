package com.MicroService.OrderService.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MicroService.OrderService.Event.OrderPlacedEvent;
import com.MicroService.OrderService.Model.Customer;
import com.MicroService.OrderService.Model.Order;
import com.MicroService.OrderService.Repository.CustomerRepo;
import com.MicroService.OrderService.Repository.OrderRepo;

@Service
public class OrderService {
	
	@Autowired
	private OrderRepo orderRepo;
	
	@Autowired
	private CustomerRepo customerRepo;
	
	@Autowired
	private OrderProducer orderProducer;
	
	public Order createOrder(Order order,String Name) {
		
		Customer customer=customerRepo.findByEmail(Name).orElseGet(
					()-> {
						Customer newCustomer=new Customer();
						newCustomer.setName(Name);
						newCustomer.setEmail(Name);
						newCustomer.setMobile("000000000");
						newCustomer.setCreatedAt(LocalDateTime.now());
						return customerRepo.save(newCustomer);
					});
		order.setCustomerId(customer.getId());
		order.setOrderNo(UUID.randomUUID().toString());
		order.setStatus("CREATED");
		order.setCreatedAt(LocalDateTime.now());
		
		Order SavedOrder= orderRepo.save(order);
		OrderPlacedEvent orderPlacedEvent=new OrderPlacedEvent(SavedOrder.getOrderNo(),Name);
		orderProducer.sendMessage(orderPlacedEvent);
		return SavedOrder;
		
	}
	public List<Order> getMyOrders(String Name){
		Customer customer =customerRepo.findByEmail(Name)
				.orElseThrow(()->new RuntimeException("User not found"));
		return orderRepo.findByCustomerId(customer.getId());
	}
	public String orderDelete(Integer orderId, String Name) {
		Customer customer=customerRepo.findByEmail(Name).orElseThrow(()->new RuntimeException("user not found"));
		
		Order order=orderRepo.findById(orderId).orElseThrow(()->new RuntimeException("order not founf"));
		
		if(!order.getCustomerId().equals(customer.getId())) {
			return "you are not allowed to delet the order";
		}
		
	    orderRepo.delete(order);
		
	    return "order deleted sucessfully";
	}
	
	

}
