package com.agan;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 	消息发送者
 * @author Administrator
 *
 */
@Component
public class UserSender {
	
	//exchange交换器名称
	@Value("${mq.config.exchange}")
	private String exchange;
	
	@Autowired
	private AmqpTemplate rabbitAmqpTemplate;

	
	/**
	 * 	发送消息的方法
	 * @param msg
	 */
	public void send(String msg) {
		//向消息队列发送消息
		//参数一：交换器名称。
		//参数二：路由键
		//参数三：消息
		this.rabbitAmqpTemplate.convertAndSend(this.exchange, "user.log.debug", "msg-->debug->from User ");
		this.rabbitAmqpTemplate.convertAndSend(this.exchange, "user.log.warn", "msg-->warn->from User ");
		this.rabbitAmqpTemplate.convertAndSend(this.exchange, "user.log.info", "msg-->info->from User ");
		this.rabbitAmqpTemplate.convertAndSend(this.exchange, "user.log.error", "msg-->error->from User ");
	}
}
