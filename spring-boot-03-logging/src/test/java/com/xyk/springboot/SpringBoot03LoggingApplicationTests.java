package com.xyk.springboot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBoot03LoggingApplicationTests {

	//记录器
	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Test
	public void contextLoads() {

		//日志的级别 由低当高 trace  debug info warn error
		//可以调整输出日志级别，日志就只会在这个级别ji以后高级神效
		logger.trace("这是trace日志");
		logger.debug("这是debug日志");
		//默认使用的是 info级别的日志
		logger.info("这是info日志");
		logger.warn("这是warn日志");
		logger.error("这是error日志");


	}

}

