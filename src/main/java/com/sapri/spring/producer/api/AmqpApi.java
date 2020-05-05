package com.sapri.spring.producer.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.sapri.spring.producer.dto.Message;
import com.sapri.spring.producer.service.AmqpService;

@RestController
public class AmqpApi {

	@Autowired
	private AmqpService service;
	
	@ResponseStatus(code = HttpStatus.ACCEPTED)
	@PostMapping("/send")
	public void sendToConsumer(@RequestBody Message message) {
		
		this.service.sendToConsumer(message);
		
	}
	
}
