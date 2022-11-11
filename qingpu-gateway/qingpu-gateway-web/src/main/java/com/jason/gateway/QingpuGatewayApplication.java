package com.jason.gateway;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author: yangwushuo
 * @time: 2022/10/30 19:38
 */
@EnableDiscoveryClient
@SpringBootApplication
@MapperScan(value = {"com.jason.gateway.dao"})
public class QingpuGatewayApplication {

  public static void main(String[] args) {
    SpringApplication.run(QingpuGatewayApplication.class, args);
  }

}
