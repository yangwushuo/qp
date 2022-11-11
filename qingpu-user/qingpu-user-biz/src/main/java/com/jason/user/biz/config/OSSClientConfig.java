package com.jason.user.biz.config;

import com.aliyun.oss.OSSClient;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 配置阿里云oss客户端信息
 * @author：yangwushuo
 * @time：2022/11/4 11:03
 */
@Configuration
@RefreshScope
@Data
public class OSSClientConfig {

    //阿里云API的内或外网域名
    @Value("${aliyun.oss.endpoint}")
    private String endpoint;
    //阿里云API的密钥Access Key ID
    @Value("${aliyun.oss.access-key-id}")
    private String accessKeyId;
    //阿里云API的密钥Access Key Secret
    @Value("${aliyun.oss.access-key-secret}")
    private String accessKeySecret;

    @Value("${aliyun.oss.bucket}")
    private String bucket;

    @Value("${aliyun.oss.folder}")
    private String folder;

    @Bean
    public OSSClient getOSSClient(){
        return new OSSClient(endpoint, accessKeyId, accessKeySecret);
    }

}
