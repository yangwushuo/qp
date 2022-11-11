package com.jason.auth;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author: yangwushuo
 * @time: 2022/10/27 11:32
 */
@EnableDiscoveryClient
@SpringBootApplication
@MapperScan({"com.jason.auth.dao"})
public class QingpuAuthApplication {

  public static void main(String[] args) {
    SpringApplication.run(QingpuAuthApplication.class, args);
  }

}
