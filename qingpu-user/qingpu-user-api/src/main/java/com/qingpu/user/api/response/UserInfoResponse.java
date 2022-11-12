package com.qingpu.user.api.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.util.List;

/**
 * @author：yangwushuo
 * @time：2022/11/3 11:50
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@ApiModel(value = "用户信息", description = "用户信息描述")
public class UserInfoResponse {

    @ApiModelProperty("主键")
    private Long id;

    @ApiModelProperty("用户名")
    private String username;

    @ApiModelProperty("邮箱")
    private String email;

    @ApiModelProperty("手机")
    private String phone;

    @ApiModelProperty("启用")
    private Boolean enabled;

    @ApiModelProperty("账户过期")
    private Boolean accountExpired;

    @ApiModelProperty("账户锁")
    private Boolean accountLocked;

    @ApiModelProperty("凭据过期")
    private Boolean credentialsExpired;

    @ApiModelProperty("头像url")
    private String portraitImage;

    @ApiModelProperty("自我简介")
    private String introduction;

    @ApiModelProperty("性别")
    private String sex;

    @ApiModelProperty("创建时间")
    private Long createTime;

    @ApiModelProperty("最近登录时间")
    private Long recentlyTime;

    @ApiModelProperty("省份")
    private Integer province;

    @ApiModelProperty("生日")
    private String birth;

    @ApiModelProperty("角色")
    private List<RoleResponse> roles;

}
