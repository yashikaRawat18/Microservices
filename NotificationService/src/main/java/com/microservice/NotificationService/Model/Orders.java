package com.microservice.NotificationService.Model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="orders")
public class Orders {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="order_no")
	private String orderNo;
	
	@Column(name="customer_id")
	private Integer customerId;
	
	private Double amount;
	private String status;
	@Column(name="created_at")
	private LocalDateTime createdAt=LocalDateTime.now();
		

}

