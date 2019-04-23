package com.xyk.task.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ScheduledService {
    //定时任务设置 cron表达式
    //@Scheduled(cron = "0 * * * * *")
    //@Scheduled(cron = "0,1,2,3,4 * * * * *")
//    @Scheduled(cron = "0-4 * * * * *")
    @Scheduled(cron = "0/4 * * * * *")//0秒启动每4秒启动一次
    public void hello(){
        System.out.println ("hello .......");
    }
}
