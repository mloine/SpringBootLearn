package com.xyk.springboot.config;

import com.xyk.springboot.service.HelloService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 指明当前类是一个配置类
 */
@Configuration
public class MyAppConfig {

    //将方法的返回值 添加到容器中 默认id为方法名
    @Bean
    public HelloService helloService02(){
        System.out.println("配置类 @Configuration注入");
        return new HelloService();
    }
}
