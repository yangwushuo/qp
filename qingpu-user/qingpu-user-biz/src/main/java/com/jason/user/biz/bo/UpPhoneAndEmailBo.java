package com.jason.user.biz.bo;

import io.swagger.annotations.ApiModel;
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
public class UpPhoneAndEmailBo {

    private String phone;

    private String email;

    private String captchaKey;

    private String captcha;

}
