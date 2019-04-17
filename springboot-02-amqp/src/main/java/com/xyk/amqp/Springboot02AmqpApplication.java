package com.xyk.amqp;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 自动配置
 * RabbitTemplate
 * AmqpAdmin
 *
 * @RabbitListener 监听消息队列的内容
 */
@EnableRabbit //开启其余注解的rabbitmq
@SpringBootApplication
public class Springboot02AmqpApplication {

	public static void main(String[] args) {
		SpringApplication.run(Springboot02AmqpApplication.class, args);
	}

}
