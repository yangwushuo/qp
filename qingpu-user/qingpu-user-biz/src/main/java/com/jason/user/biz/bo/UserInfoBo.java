package com.jason.user.biz.bo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
public class UserInfoBo {

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

    private List<RoleBo> roles;

}
