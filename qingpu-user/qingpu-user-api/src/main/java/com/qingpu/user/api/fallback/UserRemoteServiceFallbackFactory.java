package com.qingpu.user.fallback;

import com.qingpu.user.service.UserRemoteService;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * Feign UserRemoteService回退逻辑
 * @author：yangwushuo
 * @time：2022/10/26 10:51
 */
@Component
public class UserRemoteServiceFallbackFactory implements FallbackFactory<UserRemoteService> {
    @Override
    public UserRemoteService create(Throwable cause) {
        return new UserRemoteService() {
            @Override
            public String getDemo(Long uesrId) {
                return "00000000";
            }
        };
    }
}
