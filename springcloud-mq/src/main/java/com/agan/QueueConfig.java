package com.agan;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * 	创建消息队列
 * @author Administrator
 *
 */
@Configuration
public class QueueConfig {
	
	/**
	 * 	创建队列
	 * @return
	 */
	@Bean
	public Queue createQueue(){
		return new Queue("hello-queue");
	}
}