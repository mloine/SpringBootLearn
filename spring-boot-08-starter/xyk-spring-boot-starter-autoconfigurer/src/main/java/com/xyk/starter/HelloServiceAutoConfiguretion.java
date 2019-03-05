package com.xyk.starter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnWebApplication//web应用才神效
@EnableConfigurationProperties(HelloPropeties.class)
public class HelloServiceAutoConfiguretion {

    @Autowired
    HelloPropeties helloPropeties;

    @Bean
    public HelloService helloService(){
        HelloService helloService = new HelloService ();

        helloService
                .setHelloPropeties (helloPropeties);

        return helloService;
    }
}
