package com.jason.exchange.biz.po;

import lombok.*;

import java.util.List;

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
