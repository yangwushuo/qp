package com.jason.user.provider.config;

import com.aliyun.oss.OSSClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 配置阿里云oss客户端信息
 * @author：yangwushuo
 * @time：2022/11/4 11:03
 */
@Configuration
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
    //阿里云API的bucket名称
    @Value("${aliyun.oss.bucket-name}")
    private String bucketName;
    //阿里云API的文件夹名称
    @Value("${aliyun.oss.folder}")
    private String folder;

    @Bean
    public OSSClient getOSSClient(){
        return new OSSClient(endpoint, accessKeyId, accessKeySecret);
    }

}
