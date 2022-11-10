package com.qingpu.user.service;

import com.qingpu.user.fallback.UserRemoteServiceFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * 用户REST接口
 * @author：yangwushuo
 * @time：2022/10/26 10:50
 */
@FeignClient(name = "qingpu-user-provider", fallbackFactory = UserRemoteServiceFallbackFactory.class)
public interface UserRemoteService {


    /**
     * @param uesrId:
     * @return String
     * @author yangwushuo
     * @description TODO 用户id
     * @date 2022/10/26 10:59
     */
    @GetMapping("/demo/{userId}")
    String getDemo(@PathVariable("userId") Long uesrId);


}
