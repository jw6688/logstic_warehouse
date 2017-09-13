package com.zdjy.bigdata.logistic_warehouse.crawlerNews.people.mq;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class Sender {
	@Autowired
	private AmqpTemplate rabbitTemplate;
	
	public void send(String message){
		rabbitTemplate.convertAndSend("news",message);
	}
}
