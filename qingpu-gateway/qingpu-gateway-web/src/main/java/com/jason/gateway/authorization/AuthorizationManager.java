package com.jason.gateway.authorization;

import cn.hutool.core.convert.Convert;
import com.jason.gateway.constant.AuthConstant;
import com.jason.gateway.constant.RedisConstant;
import lombok.AllArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.authorization.AuthorizationDecision;
import org.springframework.security.authorization.ReactiveAuthorizationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.server.authorization.AuthorizationContext;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 鉴权管理器，用于判断是否有资源的访问权限
 * @author: yangwushuo
 * @time: 2022/10/26 23:26
 */
@Component
@AllArgsConstructor
public class AuthorizationManager implements ReactiveAuthorizationManager<AuthorizationContext> {
  private final RedisTemplate<String, Object> redisTemplate;

  private final AntPathMatcher antPathMatcher;

  @Override
  public Mono<AuthorizationDecision> check(Mono<Authentication> mono, AuthorizationContext authorizationContext) {
    // 1、从Redis中获取当前路径可访问角色列表
    URI uri = authorizationContext.getExchange().getRequest().getURI();
    String path = uri.getPath();

    //对用path进行判断是否为restful路径
    Set<Object> keys = redisTemplate.opsForHash().keys(RedisConstant.RESOURCE_ROLES_MAP);
    if (keys != null && keys.size() > 0){
      for (Object key: keys
      ) {
        String keyPath = String.valueOf(key);
        boolean res = antPathMatcher.match(keyPath, path);
        if (res){
          Object obj = redisTemplate.opsForHash().get(RedisConstant.RESOURCE_ROLES_MAP, keyPath);
          List<String> authorities = Convert.toList(String.class, obj);
          authorities = authorities.stream().map(i -> i = AuthConstant.AUTHORITY_PREFIX + i).collect(Collectors.toList());
          // 2、认证通过且角色匹配的用户可访问当前路径
          return mono
                  .filter(Authentication::isAuthenticated)
                  .flatMapIterable(Authentication::getAuthorities)
                  .map(GrantedAuthority::getAuthority)
                  .any(authorities::contains)
                  .map(AuthorizationDecision::new)
                  .defaultIfEmpty(new AuthorizationDecision(false));
        }
      }
    }
    return mono.thenReturn(new AuthorizationDecision(false));
  }

}
