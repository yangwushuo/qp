package com.jason.cs.api.fallback;

import com.jason.common.Result.CommonResult;
import com.jason.cs.api.service.CommonServiceRemoteService;
import feign.hystrix.FallbackFactory;

/**
 * @author yangwushuo
 * @time 2022/11/13 16:30
 */
public class CommonServiceRemoteServiceFallbackFactory implements FallbackFactory<CommonServiceRemoteService> {
    @Override
    public CommonServiceRemoteService create(Throwable throwable) {
        return new CommonServiceRemoteService(){
            @Override
            public CommonResult<String> sendPhoneCaptcha(String phone, String captcha) {
                return CommonResult.failed();
            }

            @Override
            public CommonResult<String> sendEmailCaptcha(String email, String captcha) {
                return CommonResult.failed();
            }
        };
    }
}
