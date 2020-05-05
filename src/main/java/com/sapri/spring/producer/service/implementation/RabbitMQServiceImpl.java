package com.sapri.spring.producer.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sapri.spring.producer.amqp.AmqpProducer;
import com.sapri.spring.producer.dto.Message;
import com.sapri.spring.producer.service.AmqpService;

@Service
public class RabbitMQServiceImpl implements AmqpService {

	@Autowired
	private AmqpProducer<Message> amqp;
	
	@Override
	public void sendToConsumer(Message message) {
		
		this.amqp.producer(message);
		
	}

	
	
}
