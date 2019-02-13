package com.xyk.springboot.config;

import com.xyk.springboot.filter.MyFilter;
import com.xyk.springboot.listener.MyListener;
import com.xyk.springboot.servlet.MyServlet;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

/**
 * web
 */
@Configuration
public class MyServiceConfig {
    //注册三大组件  ServletRegistrationBean  FilterRegistrationBean   ServletListenerRegistrationBean
    @Bean
    public ServletRegistrationBean myServlet(){
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new MyServlet (),"/myServlet");

        return servletRegistrationBean;
    }

    @Bean
    public FilterRegistrationBean myFilter(){
        FilterRegistrationBean registrationBean =    new FilterRegistrationBean ();
        registrationBean.setFilter (new MyFilter ());
        registrationBean.setUrlPatterns (Arrays.asList ("/hello","/myServlet"));
        return registrationBean;
    }
    @Bean
    public ServletListenerRegistrationBean myListener(){
        ServletListenerRegistrationBean listenerRegistrationBean=   new ServletListenerRegistrationBean(new MyListener ());
        return listenerRegistrationBean;
    }
}
