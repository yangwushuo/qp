package com.jason.auth.service.impl;

import com.jason.auth.exception.CaptchaException;
import com.jason.auth.service.CaptchaService;
import com.jason.common.Result.CommonResult;
import com.jason.common.constant.CaptchaSymbol;
import com.jason.common.util.RandUtil;
import com.jason.common.util.VerifyUtil;
import com.jason.cs.api.service.CommonServiceRemoteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

/**
 * @author：yangwushuo
 * @time：2022/11/5 19:19
 */
@Service
@Slf4j
public class CaptchaServiceImpl implements CaptchaService {

    private final RedisTemplate<String, Object> redisTemplate;

    private final CommonServiceRemoteService commonServiceRemoteService;

    public CaptchaServiceImpl(RedisTemplate<String, Object> redisTemplate, CommonServiceRemoteService commonServiceRemoteService) {
        this.redisTemplate = redisTemplate;
        this.commonServiceRemoteService = commonServiceRemoteService;
    }


    @Override
    public void sendEmailCaptcha(String email) {

        if (email == null || email.length() <=0 || !VerifyUtil.verifyEmail(email)){
            throw new CaptchaException("参数问题,发送失败");
        }

        //生成验证码
        Integer randomNumBySix = RandUtil.randomNumBySix();

        CommonResult<String> sendRes = commonServiceRemoteService.sendEmailCaptcha(email, randomNumBySix.toString());
        if (sendRes.getCode() == 200){
            //保存验证码到redis
            String key = CaptchaSymbol.addAccountCaptchaSymbol.toString().concat("captcha").concat(email);
            redisTemplate.opsForValue().set(key, randomNumBySix);
        }else{
            throw new CaptchaException("发送失败");
        }

    }

    @Override
    public void sendPhoneCaptcha(String phone) {

        if (phone == null || phone.length() <=0 || !VerifyUtil.verifyChinaPhoneNum(phone)){
            throw new CaptchaException("参数问题,发送失败");
        }

        Integer randomNumBySix = RandUtil.randomNumBySix();

        CommonResult<String> sendRes = commonServiceRemoteService.sendPhoneCaptcha(phone, randomNumBySix.toString());
        if (sendRes.getCode() == 200){
            //保存验证码到redis
            String key = CaptchaSymbol.addAccountCaptchaSymbol.toString().concat("captcha").concat(phone);
            redisTemplate.opsForValue().set(key, randomNumBySix);
        }else{
            throw new CaptchaException("发送失败");
        }

    }
}
