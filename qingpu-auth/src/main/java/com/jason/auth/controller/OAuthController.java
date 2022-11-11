package com.jason.auth.controller;

import com.jason.auth.domain.dto.TokenDto;
import com.jason.common.Result.CommonResult;
import org.springframework.security.oauth2.common.OAuth2AccessToken;

import org.springframework.security.oauth2.provider.endpoint.TokenEndpoint;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.Map;
import java.util.Objects;

/**
 * 自定义Oauth2获取令牌接口
 * @author: yangwushuo
 * @time: 2022/10/27 11:30
 */
@RestController
@RequestMapping("/oauth")
public class OAuthController {

  private final TokenEndpoint tokenEndpoint;

  public OAuthController(TokenEndpoint tokenEndpoint) {
    this.tokenEndpoint = tokenEndpoint;
  }

  /**
   * Oauth2登录认证
   */
  @PostMapping("/token")
  public CommonResult<TokenDto> postAccessToken(Principal principal, @RequestParam Map<String, String> parameters) throws HttpRequestMethodNotSupportedException {
    OAuth2AccessToken oAuth2AccessToken = tokenEndpoint.postAccessToken(principal, parameters).getBody();
    TokenDto oauth2TokenDto = TokenDto.builder()
        .token(Objects.requireNonNull(oAuth2AccessToken).getValue())
        .refreshToken(oAuth2AccessToken.getRefreshToken().getValue())
        .expiresIn(oAuth2AccessToken.getExpiresIn())
        .tokenHead("Bearer ").build();
    return CommonResult.success(oauth2TokenDto);
  }

}
