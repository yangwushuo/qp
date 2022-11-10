package com.jason.user.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 用户REST接口
 * @author：yangwushuo
 * @time：2022/10/26 10:50
 */
@EnableDiscoveryClient
@SpringBootApplication
public class KittyCloudUserProviderApp {

    public static void main(String[] args) {
        SpringApplication.run(KittyCloudUserProviderApp.class,args);
    }

}