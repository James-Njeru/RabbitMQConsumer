package com.springbatch.consumer;

import java.io.IOException;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;
import com.springbatch.model.Customer;
import com.springbatch.service.CustomerService;


@RestController
public class MessageConsumer {
	private static final String QUEUE_NAME = "icms_queue";
	
	@Autowired
	private CustomerService service;
	
	@RabbitListener(queues = QUEUE_NAME)
    public void receiveMessage(byte[] messageData) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            Customer customer = objectMapper.readValue(messageData, Customer.class);
            // Do something with myObject
            service.saveData(customer);
            System.out.println("Success. Data saved to db");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	
}
