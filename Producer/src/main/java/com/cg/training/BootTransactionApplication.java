package com.cg.training;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.Bean;




@SpringBootApplication
public class BootTransactionApplication {

	public static void main(final String[] args) {
		SpringApplication.run(BootTransactionApplication.class, args);
	
	}
	
public final static String MESSAGE_QUEUE = "message-queue";
	
	@Bean
	TopicExchange exchange() {
		return new TopicExchange("bank-exchange");
	}

	
	@Bean
	Binding binding(Queue queue, TopicExchange exchange)
	{
		return BindingBuilder.bind(queue).to(exchange).with(MESSAGE_QUEUE);
		
	}
	
}
