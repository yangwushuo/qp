package com.jason.binance.api.autoconfigure;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * 自动装配
 * @author：yangwushuo
 * @time：2022/10/26 10:30
 */
@EnableFeignClients("com.jason.binance.api")
@ComponentScan("com.jason.binance.api")
public class RemoteServiceAutoConfigure {
}
