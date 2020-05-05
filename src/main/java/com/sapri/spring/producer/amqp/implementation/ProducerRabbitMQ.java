package com.sapri.spring.producer.amqp.implementation;

import org.springframework.amqp.AmqpRejectAndDontRequeueException;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.sapri.spring.producer.amqp.AmqpProducer;
import com.sapri.spring.producer.dto.Message;

@Component
public class ProducerRabbitMQ implements AmqpProducer<Message> {

	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	@Value("${spring.rabbitmq.exchenge.routing-key.producer}")
	private String queue;
	
	@Value("${spring.rabbitmq.exchenge.producer}")
	private String exchange;
	
	@Override
	public void producer(Message message) {
		
		try {
			this.rabbitTemplate.convertAndSend(this.exchange, this.queue, message);
		} catch(Exception ex) {
			throw new AmqpRejectAndDontRequeueException(ex);
		}
		
	}
	
}
