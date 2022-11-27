package com.jason.exchange.biz.autoconfigure;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.ComponentScan;

/**
 * 自动装配
 * @author：yangwushuo
 * @time：2022/10/26 10:30
 */
@ComponentScan("com.jason.exchange.biz")
@MapperScan({"com.jason.exchange.biz.mapper"})
public class RemoteServiceAutoConfigure {
}
