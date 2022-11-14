package com.jason.cs.biz.service;

/**
 * @author yangwushuo
 * @time 2022/11/13 19:48
 */
public interface CaptchaService {

    void sendPhoneCaptcha(String phone, String captcha);

    void sendEmailCaptcha(String email, String captcha);

}
