package com.jason.cs.biz.service;

import org.springframework.scheduling.annotation.Async;

/**
 * @author yangwushuo
 * @time 2022/11/13 19:48
 */
public interface CaptchaService {

    void sendPhoneCaptcha(String phone, String captcha);

    void sendEmailCaptcha(String email, String captcha);

}
