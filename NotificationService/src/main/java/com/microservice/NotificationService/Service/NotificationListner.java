package com.microservice.NotificationService.Service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.microservice.NotificationService.Event.OrderPlacedEvent;
import com.microservice.NotificationService.Model.Customer;
import com.microservice.NotificationService.Model.Orders;
import com.microservice.NotificationService.Repository.CustomerRepo;
import com.microservice.NotificationService.Repository.OrdersRepo;

@Service
public class NotificationListner {
	
	@Autowired
	CustomerRepo customerRepo;
	@Autowired
    OrdersRepo orderRepo;
	public NotificationListner() {
		System.out.println("notificaiton");
	}
	
	@KafkaListener(topics = "order_notification", groupId = "notification-group-final")
    public void handleNotification(OrderPlacedEvent orderEvent) {
        System.out.println("------------------------------------------");
        System.out.println("NOTIFICATION RECEIVED");
        System.out.println("Order Number: " + orderEvent.getOrderNo());
        System.out.println("Sending Email to: " + orderEvent.getEmail());
        System.out.println("------------------------------------------");

        Customer customer = customerRepo.findByEmail(orderEvent.getEmail());

        if (customer == null) {
            customer = new Customer();
            customer.setEmail(orderEvent.getEmail());
            customer.setCreatedAt(LocalDateTime.now());
            
            customer = customerRepo.save(customer); 
        }

     
        Orders newOrder = new Orders();
        newOrder.setOrderNo(orderEvent.getOrderNo());
        newOrder.setStatus("Created");
        
        
        newOrder.setCustomerId(customer.getId()); 

        orderRepo.save(newOrder);
        
    }

	
}

