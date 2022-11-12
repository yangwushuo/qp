package com.jason.auth.controller;

import com.jason.auth.service.CaptchaService;
import com.jason.common.Result.CommonResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author：yangwushuo
 * @time：2022/11/5 18:16
 */
@RestController
@RequestMapping("/captcha")
public class CaptchaController {

    private final CaptchaService captchaService;

    public CaptchaController(CaptchaService captchaService) {
        this.captchaService = captchaService;
    }

    @GetMapping("/email")
    CommonResult<String> getEmailCaptcha(@RequestParam("email") String email, @RequestParam("symbol") Integer symbol){
        captchaService.sendEmailCaptcha(email, symbol);
        return CommonResult.success("验证码获取成功");
    }

    @GetMapping("/phone")
    CommonResult<String> getPhoneCaptcha(@RequestParam("phone") String phone,  @RequestParam("symbol") Integer symbol){
        captchaService.sendPhoneCaptcha(phone, symbol);
        return CommonResult.success("验证码获取成功");
    }

}
