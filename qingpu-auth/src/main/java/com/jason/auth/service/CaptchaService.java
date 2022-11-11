package com.jason.auth.service;

/**
 * 验证码服务
 * @author：yangwushuo
 * @time：2022/11/5 19:13
 */
public interface CaptchaService {

    /**
     * @return a
     * @Author yangwushuo
     * @Descrition //TODO 发送邮箱验证码
     * @Date 19:28 2022/11/5
    * @Param
     **/
    Boolean sendEmailCaptcha(String email);

    /**
     * @return a
     * @Author yangwushuo
     * @Decription //TODO 发送手机验证码
     * @Date 19:28 2022/11/5
     * @Param
     **/
    Boolean sendPhoneCaptcha(String phone);

}
