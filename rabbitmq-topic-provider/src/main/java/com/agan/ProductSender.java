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
public class ProductSender {
	
	//exchange交换器名称
	@Value("${mq.config.exchange}")
	private String exchange;
	
	@Autowired
	private AmqpTemplate rabbitAmqpTemplate;
	
	
	/**
	 * 	产品发送消息的方法
	 */
	public void send(String msg) {
		this.rabbitAmqpTemplate.convertAndSend(this.exchange, "product.log.debug", "msg-->debug->from Product ");
		this.rabbitAmqpTemplate.convertAndSend(this.exchange, "product.log.warn", "msg-->warn->from Product ");
		this.rabbitAmqpTemplate.convertAndSend(this.exchange, "product.log.info", "msg-->info->from Product ");
		this.rabbitAmqpTemplate.convertAndSend(this.exchange, "product.log.error", "msg-->error->from Product ");
	}

}
