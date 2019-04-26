package com.xyk.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 *
 * 1.引入spring Securtiy
 * 2.编写配置类
 * 	extends WebSecurityConfigurerAdapter
 * 	@EnableWebSecurity
 * 	3.控制请求的访问权限
 */
@SpringBootApplication
public class Springboot05SecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(Springboot05SecurityApplication.class, args);
	}

}
