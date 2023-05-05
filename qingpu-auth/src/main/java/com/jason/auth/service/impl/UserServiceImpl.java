package com.jason.auth.service.impl;


import com.jason.auth.constant.MessageConstant;
import com.jason.auth.dao.UserMapper;
import com.jason.auth.domain.dto.UserDto;
import com.jason.auth.domain.mapstruct.UserMapperStruct;
import com.jason.auth.domain.po.UserPo;
import com.jason.auth.service.UserService;
import com.jason.auth.service.principal.UserPrincipal;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AccountExpiredException;
import org.springframework.security.authentication.CredentialsExpiredException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * 用户管理业务类
 * @author: yangwushuo
 * @time: 2022/10/27 11:31
 */
@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

  private final PasswordEncoder passwordEncoder;
  private final UserMapper userMapper;
  private final UserMapperStruct userMapperStruct;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

    if(username.indexOf(":") == -1){
      throw new UsernameNotFoundException(MessageConstant.USERNAME_PASSWORD_ERROR);
    }

    String[] usernameSplit = username.split(":");
    System.out.println("jason:)"+usernameSplit[1]);
    Integer flag = Integer.valueOf(usernameSplit[0]);
    String content = usernameSplit[1];

    //查询用户信息
    UserPo userPo = userMapper.getUserInfo(flag, content);

    UserDto userDto = userMapperStruct.userPo2UserDto(userPo);

    if (userDto == null){
      throw new UsernameNotFoundException(MessageConstant.USERNAME_PASSWORD_ERROR);
    }

    UserPrincipal userPrincipal = new UserPrincipal(userDto);

    //判断账户
    if (!userPrincipal.isEnabled()) {
      throw new DisabledException(MessageConstant.ACCOUNT_DISABLED);
    } else if (!userPrincipal.isAccountNonLocked()) {
      throw new LockedException(MessageConstant.ACCOUNT_LOCKED);
    } else if (!userPrincipal.isAccountNonExpired()) {
      throw new AccountExpiredException(MessageConstant.ACCOUNT_EXPIRED);
    } else if (!userPrincipal.isCredentialsNonExpired()) {
      throw new CredentialsExpiredException(MessageConstant.CREDENTIALS_EXPIRED);
    }

    return userPrincipal;
  }

}
