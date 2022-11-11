package com.jason.auth.service.principal;

import com.jason.auth.domain.dto.UserDto;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

/**
 * 登录用户信息
 * @author: yangwushuo
 * @time: 2022/10/27 11:32
 */
@Data
public class UserPrincipal implements UserDetails {

  /**
   * ID
   */
  private Long id;
  /**
   * 用户名
   */
  private String username;
  /*
  * 邮箱
  * */
  private String email;
  /**
   * 用户密码
   */
  private String password;
  /**
   * 用户状态
   */
  private Boolean enabled;
  /**
   * 账户过期
   */
  private Boolean accountExpired;
  /**
   * 锁定
   */
  private Boolean accountLocked;
  /**
   * 证书过期
   */
  private Boolean credentialsExpired;

  /**
   * 权限数据
   */
  private Collection<SimpleGrantedAuthority> authorities;

  public UserPrincipal(UserDto user) {
    this.setId(user.getId());
    this.setUsername(user.getUsername());
    this.setPassword(user.getPassword());
    this.setEmail(user.getEmail());
    this.setEnabled(user.getEnabled());
    this.setAccountExpired(user.getAccountExpired());
    this.setAccountLocked(user.getAccountLocked());
    this.setCredentialsExpired(user.getCredentialsExpired());

    if (user.getRoleDtos() != null) {
      authorities = new ArrayList<>();
      user.getRoleDtos().forEach(role -> authorities.add(new SimpleGrantedAuthority(role.getName())));
    }

  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return this.authorities;
  }

  @Override
  public String getPassword() {
    return this.password;
  }

  @Override
  public String getUsername() {
    return this.username;
  }

  @Override
  public boolean isAccountNonExpired() {
    return this.accountExpired;
  }

  @Override
  public boolean isAccountNonLocked() {
    return this.accountLocked;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return this.credentialsExpired;
  }

  @Override
  public boolean isEnabled() {
    return this.enabled;
  }

}
