package com.xyk.security.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter{
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //super.configure (http);
        //定制请求的授权规则
        http.authorizeRequests ().antMatchers ("/").permitAll ()
                .antMatchers ("/level1/**").hasRole ("VIP1")
                .antMatchers ("/level2/**").hasRole ("VIP2")
                .antMatchers ("/level3/**").hasRole ("VIP3");
        //开启自动配置的登录功能
        http.formLogin ();
        //1./loginl来到登录页
        //2.login?error 表示登录十八
        //3.更多详细规则
        //开启自动配置的注销功能
        http.logout ();
        //1.访问/logout
    }


    //定义认证规则
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //super.configure (auth);
        auth.inMemoryAuthentication ()
                .withUser ("zhangsan").password ("123456").roles ("VIP1","VIP2")
                .and().withUser ("lisi").password ("123456").roles ("VIP3","VIP2")
                .and().withUser ("wangwu").password ("123456").roles ("VIP1","VIP3");
    }
}
