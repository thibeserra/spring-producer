package com.sapri.spring.producer.service;

import com.sapri.spring.producer.dto.Message;

public interface AmqpService {

	void sendToConsumer(Message message);
	
}
