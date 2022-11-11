package com.jason.auth.domain.dto;


import lombok.*;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * @author: yangwushuo
 * @time: 2022/10/27 11:31
 */
@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@Builder(toBuilder = true)
@ToString
public class UserDto {

  private Long id;

  private String username;

  private String email;

  private String password;

  private String phone;

  private Boolean enabled;

  private Boolean accountExpired;

  private Boolean accountLocked;

  private Boolean credentialsExpired;

  private List<RoleDto> roleDtos;
}
