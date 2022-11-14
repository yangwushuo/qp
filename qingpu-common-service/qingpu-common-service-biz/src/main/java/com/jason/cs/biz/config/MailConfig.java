package com.jason.cs.biz.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @author：yangwushuo
 * @time：2022/11/5 21:01
 */
@Configuration
@Data
public class MailConfig {

    // 配置文件中我的qq邮箱
    @Value("${spring.mail.username}")
    private String fromEmail;

}
