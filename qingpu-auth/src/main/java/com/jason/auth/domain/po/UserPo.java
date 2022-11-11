package com.jason.auth.domain.po;

import com.jason.auth.domain.dto.RoleDto;
import lombok.*;
import lombok.experimental.Accessors;
import org.apache.ibatis.type.Alias;

import java.util.List;

/**
 * @author：yangwushuo
 * @time：2022/10/28 19:04
 */
@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
@Accessors(chain = true)
@Alias("userpo")
public class UserPo{

    private Long id;

    private String username;

    private String email;

    private String phone;

    private String password;

    private Boolean enabled;

    private Boolean accountExpired;

    private Boolean accountLocked;

    private Boolean credentialsExpired;

    private List<RolePo> rolePos;

}
