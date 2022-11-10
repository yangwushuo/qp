package com.jason.auth.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import java.util.List;

/**
 * @author: yangwushuo
 * @time: 2022/10/27 11:31
 */
@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
@TableName("user")
public class User {

  @TableId(value = "id", type = IdType.AUTO)
  private Long id;

  @TableField(value = "username")
  private String username;

  @TableField(value = "password")
  private String password;

  @TableField(exist = false)
  private Integer status;

  private List<String> roles;
}
