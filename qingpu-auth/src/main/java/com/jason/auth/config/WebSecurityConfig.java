package com.jason.auth.config;

import com.jason.auth.component.MyBasicAuthenticationEntryPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.autoconfigure.security.servlet.EndpointRequest;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.*;
import java.io.IOException;

/**
 * SpringSecurity配置
 * @author: yangwushuo
 * @time: 2022/10/27 11:30
 */
@Configuration
@EnableWebSecurity
@EnableAuthorizationServer
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

  @Autowired
  private MyBasicAuthenticationEntryPoint authenticationEntryPoint;

  @Override
  protected void configure(HttpSecurity http) throws Exception {

    http.authorizeRequests()
        .antMatchers("/rsa/publicKey", "/captcha/**").permitAll()
        .anyRequest().authenticated()
        .and().formLogin();

  }

  @Bean
  @Override
  protected AuthenticationManager authenticationManager() throws Exception {
    return super.authenticationManager();
  }

//  /**
//   * 认证是由 AuthenticationManager 来管理的，
//   * 但是真正进行认证的是 AuthenticationManager 中定义的 AuthenticationProvider，
//   * 用于调用userDetailsService进行验证
//   */
//  @Bean
//  public AuthenticationProvider daoAuthenticationProvider() {
//    DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
//    daoAuthenticationProvider.setUserDetailsService(userService);
//    daoAuthenticationProvider.setHideUserNotFoundExceptions(false);
//    daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
//    return daoAuthenticationProvider;
//  }

  @Override
  public void configure(WebSecurity web){
    web.ignoring()
            .antMatchers("/scripts/**/*.{js,html}")
            .antMatchers("/views/about.html")
            .antMatchers("/views/detail.html")
            .antMatchers("/views/home.html")
            .antMatchers("/views/login.html")
            .antMatchers("/bower_components/**")
            .antMatchers("/resources/*.json");
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

}
