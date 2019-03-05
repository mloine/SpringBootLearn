package com.xyk.springboot;

import com.xyk.springboot.bean.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * springboot单元测试
 * 可以在测试期间方便 类似编码自动注入容器的功能
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBoot02ConfigApplicationTests {

	@Autowired
	Person person;
	@Autowired
	ApplicationContext ioc;

	@Test
	public void contextLoads() {
		System.out.print(person);
	}
	
	@Test
	public void testHelloService(){
		boolean helloService = ioc.containsBean("helloService02");
		System.out.println(helloService);
	}

}

