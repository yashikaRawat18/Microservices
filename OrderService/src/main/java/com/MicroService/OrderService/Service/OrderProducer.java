package com.MicroService.OrderService.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import com.MicroService.OrderService.Event.OrderPlacedEvent;


@Service
public class OrderProducer {
	
	@Autowired
	private KafkaTemplate<String, OrderPlacedEvent> kafkaTemplate;
	
	public void sendMessage(OrderPlacedEvent event) {
		
		Message<OrderPlacedEvent> message=MessageBuilder
				.withPayload(event)
				.setHeader(KafkaHeaders.TOPIC,"order_notification")
				.build();
		kafkaTemplate.send(message);
		System.out.println("kafka messsage sent"+message);
		
	}
	

}
