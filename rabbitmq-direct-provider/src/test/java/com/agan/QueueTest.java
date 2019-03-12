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
	private InfoSender infoSender;
	
	@Autowired
	private ErrorSender errorSender;
	
	@Test
	public void test1() throws InterruptedException {
		while(true) {
			Thread.sleep(1000);
			this.infoSender.send("Hello Rabbit MQ .Info");
			this.errorSender.send("Hello Rabbit MQ .Error");
			this.infoSender.send("Hello Rabbit MQ .Info");
		}
	}
}
