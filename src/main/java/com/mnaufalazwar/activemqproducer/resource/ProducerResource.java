package com.mnaufalazwar.activemqproducer.resource;

import javax.jms.Queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/publish")
public class ProducerResource {
	
	@Autowired
	private JmsTemplate jmsTemplate;
	
	@Autowired
	private Queue queue;

	@RequestMapping("/{message}")
	public String publishMessage(@PathVariable("message") String message) {
		
		jmsTemplate.convertAndSend(queue, message);
		
		return "Successfully Published";
	}
}
