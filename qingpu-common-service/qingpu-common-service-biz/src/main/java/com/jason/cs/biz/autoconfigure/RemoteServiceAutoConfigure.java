package com.jason.cs.biz.autoconfigure;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * 自动装配
 * @author：yangwushuo
 * @time：2022/10/26 10:30
 */
@EnableFeignClients("com.jason.cs.biz")
@EnableAsync
@ComponentScan("com.jason.cs.biz")
public class RemoteServiceAutoConfigure {
}
