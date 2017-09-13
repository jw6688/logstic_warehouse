package com.zdjy.bigdata.logistic_warehouse.crawlerNews.china.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
@RunWith(SpringRunner.class)
@SpringBootTest
public class MQSendTest {
	@Autowired
	private AmqpTemplate rabbitTemplate;
	@Test
	public void test001(){
		//第一个参数是queue
		//第二个参数是内容
		while(true){
			rabbitTemplate.convertAndSend("news","asd");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
