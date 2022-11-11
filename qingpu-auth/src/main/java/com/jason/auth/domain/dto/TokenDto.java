package com.jason.auth.domain.dto;


import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Oauth2获取Token返回信息封装
 * @author: yangwushuo
 * @time: 2022/10/27 11:31
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Builder
public class TokenDto {
  /**
   * 访问令牌
   */
  private String token;
  /**
   * 刷新令牌
   */
  private String refreshToken;
  /**
   * 访问令牌头前缀
   */
  private String tokenHead;
  /**
   * 有效时间（秒）
   */
  private int expiresIn;
}
