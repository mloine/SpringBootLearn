package com.xyk.amqp;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.xyk.amqp.bean.Book;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Springboot02AmqpApplicationTests {

	@Autowired
	RabbitTemplate rabbitTemplate;

	@Autowired
	AmqpAdmin amqpAdmin;

	@Test
	public void  createExchange(){
		//amqpAdmin.declareExchange (new DirectExchange ("amqpAdmin.exchange"));

		//amqpAdmin.declareQueue (new Queue ("amqpAdmin.queue",true));

		//创建绑定规则
		amqpAdmin.declareBinding (new Binding ("amqpAdmin.queue",Binding.DestinationType.QUEUE,"amqpAdmin.exchange","amqpAdmin.haha",null));



	}

	/**
	 * 1.点对点
	 * 2.
	 * 3.
	 */
	@Test
	public void contextLoads() {
		//Message 需要自己构造一个 定义内容 和 消息头
		//rabbitTemplate.send ("exchange.direct","","");

		//只要传入要发送的对象，自动序列化发送给rabbitmq
		Map<String,Object> map = new HashMap<> ();
		map.put ("msg","这是第一个消息");
		map.put ("date", Arrays.asList ("helloxyk",123,true));
		Book Book = new Book ("username", "String author");
		rabbitTemplate.convertAndSend ("exchange.direct","xyk.news", Book);
	}

	//接受数据，如何将数据自动转化json发送
	@Test
	public void receive(){
		Object o = rabbitTemplate.receiveAndConvert ("xyk.news");
		System.out.println (o.getClass ());
		System.out.println (o);
	}
	//广播
	@Test
	public void sendMessage(){
		rabbitTemplate.convertAndSend ("exchange.fanout","fanout",new Book ("三国xyk","罗贯中"));
	}
}
