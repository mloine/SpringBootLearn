package com.xyk.springboot.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class DruidConfig {

    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource druid(){
        return new DruidDataSource ();
    }


    //配置Druidd的监控
    //1.配置一个管理后台的servlet
    @Bean
    public ServletRegistrationBean statViewServlet(){

        //配置durid管理的servlet
        ServletRegistrationBean bean = new ServletRegistrationBean (new StatViewServlet (), "/druid/*");

        Map<String, String> map = new HashMap<String,String> ();
        map.put ("loginUsername","admin");
        map.put ("loginPassword","123456");
        map.put ("allow","");//默认所有
        map.put ("deny","");//拒绝访问的ip 192.168.43.99

        bean.setInitParameters (map);

        return bean;
    }

    //2.配置一个外部监控的filter 监控web应用
    @Bean
    public FilterRegistrationBean webStataFilter(){
        FilterRegistrationBean filter = new FilterRegistrationBean ();
        filter.setFilter (new WebStatFilter ());

        Map<String, String> map = new HashMap<String,String> ();
        map.put ("exclusions","*.js,*.css,/druid/*");//排除

        filter.setInitParameters (map);
        filter.setUrlPatterns (Arrays.asList ("/"));

        return filter;
    }
}
