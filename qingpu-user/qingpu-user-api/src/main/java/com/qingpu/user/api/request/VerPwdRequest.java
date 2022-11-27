package com.qingpu.user.api.request;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author：yangwushuo
 * @time：2022/11/14 22:57
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "校验用户密码", description = "校验用户密码请求信息")
public class VerPwdRequest {

    private String password;

}
