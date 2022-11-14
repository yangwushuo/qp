package com.jason.cs.api.service;

import com.jason.common.Result.CommonResult;
import com.jason.cs.api.fallback.CommonServiceRemoteServiceFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author yangwushuo
 * @time 2022/11/13 16:29
 */
@FeignClient(name = "qingpu-common-service-provider", fallbackFactory = CommonServiceRemoteServiceFallbackFactory.class)
public interface CommonServiceRemoteService {

    @GetMapping("/cs/send/captcha/phone")
    CommonResult<String> sendPhoneCaptcha(@RequestParam("phone")String phone, @RequestParam("captcha")String captcha);

    @GetMapping("/cs/send/captcha/email")
    CommonResult<String> sendEmailCaptcha(@RequestParam("email")String email, @RequestParam("captcha")String captcha);

}
