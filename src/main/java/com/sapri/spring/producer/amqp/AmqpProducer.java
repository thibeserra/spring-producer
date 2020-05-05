package com.sapri.spring.producer.amqp;

public interface AmqpProducer<T> {

	void producer(T t);
	
}
