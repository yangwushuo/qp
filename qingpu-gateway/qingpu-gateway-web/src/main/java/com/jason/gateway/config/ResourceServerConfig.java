package com.jason.gateway.config;

import com.jason.gateway.authorization.AuthorizationManager;
import com.jason.gateway.component.RestAuthenticationEntryPoint;
import com.jason.gateway.component.RestfulAccessDeniedHandler;
import com.jason.gateway.constant.AuthConstant;
import com.jason.gateway.dao.GatewayMapper;
import com.jason.gateway.domain.dto.IgnoreUrlDto;
import com.jason.gateway.domain.mapstruct.GatewayMapperStruct;
import com.jason.gateway.filter.IgnoreUrlsRemoveJwtFilter;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.SecurityWebFiltersOrder;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.oauth2.server.resource.authentication.JwtGrantedAuthoritiesConverter;
import org.springframework.security.oauth2.server.resource.authentication.ReactiveJwtAuthenticationConverterAdapter;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.util.AntPathMatcher;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

/**
 * 资源服务器配置
 * @author: yangwushuo
 * @time: 2022/10/26 23:27
 */
@AllArgsConstructor
@Configuration
@EnableWebFluxSecurity
public class ResourceServerConfig {
  private final AuthorizationManager authorizationManager;

  private final RestfulAccessDeniedHandler restfulAccessDeniedHandler;
  private final RestAuthenticationEntryPoint restAuthenticationEntryPoint;
  private final IgnoreUrlsRemoveJwtFilter ignoreUrlsRemoveJwtFilter;

  private final GatewayMapperStruct gatewayMapperStruct;

  private final GatewayMapper gatewayMapper;

  @Bean
  public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http) {
    http.oauth2ResourceServer().jwt().jwtAuthenticationConverter(jwtAuthenticationConverter());
    // 1、自定义处理JWT请求头过期或签名错误的结果
    http.oauth2ResourceServer().authenticationEntryPoint(restAuthenticationEntryPoint);

    //获取白名单
    List<IgnoreUrlDto> ignoreUriDtos = gatewayMapperStruct.ignoreUriPoList2IgnoreUriDtoList(gatewayMapper.getAllIgnoreUrls());
    List<String> ignoreUris = new ArrayList<>();
    if (ignoreUriDtos.size() > 0){
      ignoreUriDtos.stream().forEach(ignoreUriDto -> {
        ignoreUris.add(ignoreUriDto.getUrl());
      });
    }

    // 2、对白名单路径，直接移除JWT请求头
    http.addFilterBefore(ignoreUrlsRemoveJwtFilter, SecurityWebFiltersOrder.AUTHENTICATION);

    http.authorizeExchange()
        .pathMatchers(ignoreUris.toArray(new String[ignoreUris.size()])).permitAll() // 白名单配置
        .anyExchange().access(authorizationManager) // 鉴权管理器配置
        .and().exceptionHandling()
        .accessDeniedHandler(restfulAccessDeniedHandler) // 处理未授权
        .authenticationEntryPoint(restAuthenticationEntryPoint) // 处理未认证
        .and().csrf().disable();
    return http.build();
  }

  @Bean
  public Converter<Jwt, ? extends Mono<? extends AbstractAuthenticationToken>> jwtAuthenticationConverter() {
    JwtGrantedAuthoritiesConverter jwtGrantedAuthoritiesConverter = new JwtGrantedAuthoritiesConverter();
    jwtGrantedAuthoritiesConverter.setAuthorityPrefix(AuthConstant.AUTHORITY_PREFIX);
    jwtGrantedAuthoritiesConverter.setAuthoritiesClaimName(AuthConstant.AUTHORITY_CLAIM_NAME);
    JwtAuthenticationConverter jwtAuthenticationConverter = new JwtAuthenticationConverter();
    jwtAuthenticationConverter.setJwtGrantedAuthoritiesConverter(jwtGrantedAuthoritiesConverter);
    return new ReactiveJwtAuthenticationConverterAdapter(jwtAuthenticationConverter);
  }

}
