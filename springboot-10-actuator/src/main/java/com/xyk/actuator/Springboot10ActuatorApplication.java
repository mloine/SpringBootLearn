package com.xyk.actuator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 1.自定义健康状态指示器
 * 1.编写一个自定义只是器 HealthIndicator
 * 2.起名必须符合规范 xxxHealthIndicator
 * 3.加入容器
 */
@SpringBootApplication
public class Springboot10ActuatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(Springboot10ActuatorApplication.class, args);
	}

}
