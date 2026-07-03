package com.microservice.NotificationService.Event;

import lombok.Data;

@Data 
public class OrderPlacedEvent {
	private String orderNo;
	private String email;
}
