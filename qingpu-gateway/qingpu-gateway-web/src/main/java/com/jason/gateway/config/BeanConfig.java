package com.jason.gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.AntPathMatcher;

/**
 * @author：yangwushuo
 * @time：2022/10/31 19:22
 */
@Configuration
public class BeanConfig {

    @Bean
    AntPathMatcher antPathMatcher(){
        return new AntPathMatcher();
    }

}
