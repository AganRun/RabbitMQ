package com.agan;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=SpringBootServerApplication.class)
public class QueueTest {

	@Autowired
	private UserSender infoSender;
	
	@Autowired
	private OrderSender orderSender;
	
	@Autowired
	private ProductSender productSender;
	
	
	@Test
	public void test1() throws InterruptedException {
		while(true) {
			Thread.sleep(1000);
			this.infoSender.send("Hello Rabbit MQ .infoSender");
			this.productSender.send("Hello Rabbit MQ .productSender");
			this.orderSender.send("Hello Rabbit MQ .orderSender");
		}
	}
}
