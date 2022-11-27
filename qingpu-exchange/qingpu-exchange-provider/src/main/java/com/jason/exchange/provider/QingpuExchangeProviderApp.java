package com.jason.exchange.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author：yangwushuo
 * @time：2022/11/17 14:43
 */
@EnableDiscoveryClient
@SpringBootApplication
public class QingpuExchangeProviderApp {
    public static void main(String[] args) {
        SpringApplication.run(QingpuExchangeProviderApp.class, args);
    }
}
