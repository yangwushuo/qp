package com.qingpu.user.api.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

/**
 * @author：yangwushuo
 * @time：2022/11/3 12:07
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@ApiModel(value = "更新用户信息请求", description = "更新用户信息请求信息")
public class UpUserInfoRequest {

    @ApiModelProperty("用户名")
    private String username;

    @ApiModelProperty("邮箱")
    private String email;

    @ApiModelProperty("性别")
    private String sex;

    @ApiModelProperty("介绍")
    private String introduction;

    @ApiModelProperty("省份代号")
    private Integer province;

    @ApiModelProperty("出生日期")
    private String birth;

}
