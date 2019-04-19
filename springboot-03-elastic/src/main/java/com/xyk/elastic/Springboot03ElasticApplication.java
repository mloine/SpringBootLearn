package com.xyk.elastic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * springboot 默认支持两种技术来支持和ES交互
 * 1.JEST(默认不生效)
 *	需要导入jest的工具包
 * 2.SpringDate ElasticSearch
 * 		版本适配
 * 				spring data elasticsearch	elasticsearch
									 3.2.x	6.5.0
									 3.1.x	6.2.2
									 3.0.x	5.5.0
									 2.1.x	2.4.0
									 2.0.x	2.2.0
									 1.3.x	1.5.2
 * 		1）client clusterNodes : clusterName
 * 		2) ElasticsearchTemplate
 * 		3) 编写一个ElasticsearchRepositiory
 *
 * 	https://github.com/spring-projects/spring-data-elasticsearch
 */
@SpringBootApplication
public class Springboot03ElasticApplication {

	public static void main(String[] args) {
		SpringApplication.run(Springboot03ElasticApplication.class, args);
	}

}
