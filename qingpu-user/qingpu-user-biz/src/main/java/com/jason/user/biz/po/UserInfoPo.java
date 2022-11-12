package com.jason.user.biz.po;

import com.jason.user.biz.bo.RoleBo;
import lombok.*;

import java.util.List;

/**
 * @author：yangwushuo
 * @time：2022/11/1 21:11
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class UserInfoPo {

    private Long id;

    private String username;

    private String email;

    private String phone;

    private Boolean enabled;

    private Boolean accountExpired;

    private Boolean accountLocked;

    private Boolean credentialsExpired;

    private String portraitImage;

    private String introduction;

    private String sex;

    private Long createTime;

    private Long recentlyTime;

    private Integer province;

    private String birth;

    private List<RolePo> roles;

}
