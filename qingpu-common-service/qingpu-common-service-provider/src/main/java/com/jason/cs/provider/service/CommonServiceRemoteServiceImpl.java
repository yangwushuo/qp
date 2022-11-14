package com.jason.cs.provider.service;

import com.aliyun.sdk.service.dysmsapi20170525.AsyncClient;
import com.jason.common.Result.CommonResult;
import com.jason.common.util.RandUtil;
import com.jason.common.util.VerifyUtil;
import com.jason.cs.api.service.CommonServiceRemoteService;
import com.jason.cs.biz.service.CaptchaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.HashMap;
import java.util.Map;

/**
 * @author yangwushuo
 * @time 2022/11/13 16:38
 */
@RestController
@Slf4j
public class CommonServiceRemoteServiceImpl implements CommonServiceRemoteService {

    private final CaptchaService captchaService;

    public CommonServiceRemoteServiceImpl(CaptchaService captchaService) {
        this.captchaService = captchaService;
    }

    @Override
    public CommonResult<String> sendPhoneCaptcha(String phone, String captcha) {
        captchaService.sendPhoneCaptcha(phone, captcha);
        return CommonResult.success("发送成功");
    }

    @Override
    public CommonResult<String> sendEmailCaptcha(String email, String captcha) {
        captchaService.sendEmailCaptcha(email, captcha);
        return CommonResult.success("发送成功");
    }

}
