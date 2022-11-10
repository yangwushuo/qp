package com.jason.auth.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @author：yangwushuo
 * @time：2022/11/6 11:15
 */
@Configuration
@Data
public class AliyunConfig {

    @Value("${aliyun.regionId}")
    private String regionId;

    @Value("${aliyun.access-key-id}")
    private String accessKeyId;

    @Value("${aliyun.access-key-secret}")
    private String accessKeySecret;

    @Value("${}")
    private String sign;


}
