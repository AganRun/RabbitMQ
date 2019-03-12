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
	private Sender sender;
	
	
	@Test
	public void test1() throws InterruptedException {
		sender.send("Hello Rabbit MQ .Order-fanout");
	}
}
