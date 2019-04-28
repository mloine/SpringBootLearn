package com.xyk.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 1.引入dubbo和zkclient相关依赖
 * 2.配置dubbo的注册中心地址
 * 3.应用服务
 */
@SpringBootApplication
public class CunsumerUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(CunsumerUserApplication.class, args);
    }

}
