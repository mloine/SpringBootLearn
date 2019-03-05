package com.xyk.springboot.config;

import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.boot.autoconfigure.ConfigurationCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//配置扫描那些包下的mapper文件  批量扫描
@MapperScan(value = "com.xyk.springboot.mapper")
@Configuration
public class MyBatisConfig {
    //自定义mybatis的配置规则
    @Bean
    public ConfigurationCustomizer configurationCustomizer() {

       return new ConfigurationCustomizer(){

            @Override
            public void customize(org.apache.ibatis.session.Configuration configuration) {
                configuration.setMapUnderscoreToCamelCase (true);
            }
        };

    }
}