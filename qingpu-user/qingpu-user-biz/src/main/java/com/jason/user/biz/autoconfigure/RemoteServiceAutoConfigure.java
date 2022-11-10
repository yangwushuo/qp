package com.qingpu.user.api.autoconfigure;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * 自动装配
 * @author：yangwushuo
 * @time：2022/10/26 10:30
 */
@EnableFeignClients("com.qingpu.user.api")
@ComponentScan("com.qingpu.user.api")
public class RemoteServiceAutoConfigure {
}
