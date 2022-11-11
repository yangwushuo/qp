package com.jason.gateway.filter;

import com.jason.gateway.dao.GatewayMapper;
import com.jason.gateway.domain.dto.IgnoreUrlDto;
import com.jason.gateway.domain.mapstruct.GatewayMapperStruct;
import lombok.AllArgsConstructor;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;

import javax.annotation.PostConstruct;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

/**
 * 白名单路径访问时需要移除JWT请求头
 * @author: yangwushuo
 * @time: 2022/10/26 21:59
 */
@Component
@AllArgsConstructor
public class IgnoreUrlsRemoveJwtFilter implements WebFilter {

  private final GatewayMapper gatewayMapper;

  private final GatewayMapperStruct gatewayMapperStruct;

  private List<String> ignoreUrls;

  @PostConstruct
  public void init(){
    ignoreUrls = new ArrayList<>();
    List<IgnoreUrlDto> ignoreUriDtos = gatewayMapperStruct.ignoreUriPoList2IgnoreUriDtoList(gatewayMapper.getAllIgnoreUrls());
    if (ignoreUriDtos != null && ignoreUriDtos.size() > 0){
      ignoreUriDtos.stream().forEach(ignoreUrlDto -> {
        ignoreUrls.add(ignoreUrlDto.getUrl());
      });
    }
    System.out.println("白名单路径:");
    ignoreUrls.stream().forEach(System.out::println);
  }

  @Override
  public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {
    ServerHttpRequest request = exchange.getRequest();
    //获取请求路径
    URI uri = request.getURI();
    PathMatcher pathMatcher = new AntPathMatcher();
    // 白名单路径移除JWT请求头
    for (String ignoreUrl : ignoreUrls) {
      if (pathMatcher.match(ignoreUrl, uri.getPath())) {
        request = exchange.getRequest().mutate().header("Authorization", "").build();
        exchange = exchange.mutate().request(request).build();
        return chain.filter(exchange);
      }
    }
    return chain.filter(exchange);
  }

}
