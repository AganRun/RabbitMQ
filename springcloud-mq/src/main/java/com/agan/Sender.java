package com.agan;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 	消息发送者
 * @author Administrator
 *
 */
@Component
public class Sender {
	
	@Autowired
	private AmqpTemplate rabbitAmqpTemplate;

	public void send(String msg) {
		//向消息队列发送消息
		this.rabbitAmqpTemplate.convertAndSend("hello-queue", msg);
	}
}
