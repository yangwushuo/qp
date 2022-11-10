package com.jason.user.biz.dto;

import lombok.*;

/**
 * @author：yangwushuo
 * @time：2022/11/1 21:11
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class UserInfoDto {

    private Long id;
    private String username;
    private String email;
    private Boolean enabled;
    private Boolean accountExpired;
    private Boolean accountLocked;
    private Boolean credentialsExpired;
    private String introduction;
    private String sex;
    private String createTime;
    private String recentlyTime;
    private Integer province;
    private String birth;

}
