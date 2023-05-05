package com.qingpu.user.api.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

/**
 * @author：yangwushuo
 * @time：2022/11/6 14:01
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@ApiModel(value = "创建账户", description = "创建账户请求信息")
public class AddAccountRequest {

    @ApiModelProperty("标记")
    private Integer symbol;

    @ApiModelProperty("内容")
    private String content;

    @ApiModelProperty("密码")
    private String password;

    @ApiModelProperty("验证码key")
    private String captchaKey;

    @ApiModelProperty("验证码")
    private String captcha;

    @ApiModelProperty("时间戳")
    private Long timestamp;

}
