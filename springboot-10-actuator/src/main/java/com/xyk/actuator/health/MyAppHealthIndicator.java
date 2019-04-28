package com.xyk.actuator.health;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class MyAppHealthIndicator implements HealthIndicator{
    @Override
    public Health health() {

        //自定义检查方式
        //Health.up ().build () ok
        //
       return Health.down ().withDetail ("msg","服务异常").build ();
//        return Health.up ().build ();
    }
}
