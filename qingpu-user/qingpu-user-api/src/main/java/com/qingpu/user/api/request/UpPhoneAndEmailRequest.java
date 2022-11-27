package com.qingpu.user.api.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author：yangwushuo
 * @time：2022/11/15 14:20
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "更新用户手机邮箱", description = "更新用户手机邮箱请求")
public class UpPhoneAndEmailRequest {

    @ApiModelProperty("绑定手机")
    private String phone;

    @ApiModelProperty("绑定邮箱")
    private String email;

    @ApiModelProperty("验证码key")
    private String captchaKey;

    @ApiModelProperty("验证码")
    private String captcha;

}
