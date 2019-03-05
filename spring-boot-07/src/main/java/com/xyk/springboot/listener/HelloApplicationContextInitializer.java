package com.xyk.springboot.listener;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;

public class HelloApplicationContextInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext>{

    public HelloApplicationContextInitializer() {
    }

    @Override
    public void initialize(ConfigurableApplicationContext configurableApplicationContext) {
        System.out.println ("ApplicationContextInitializer .... initialize ...." + configurableApplicationContext);
    }
}
