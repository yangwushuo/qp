package com.qingpu.user.api.fallback;

import com.jason.common.Result.CommonResult;
import com.qingpu.user.api.request.AddAccountRequest;
import com.qingpu.user.api.request.UpUserInfoRequest;
import com.qingpu.user.api.response.FollowResponse;
import com.qingpu.user.api.response.UserInfoResponse;
import com.qingpu.user.api.service.UserRemoteService;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

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
            public CommonResult<UserInfoResponse> getUserInfo(String user) {
                return CommonResult.failed("获取用户信息失败");
            }

            @Override
            public CommonResult<String> upUserInfo(String userInfo, UpUserInfoRequest upUserInfoRequest) {
                return CommonResult.failed("更新用户信息失败");
            }

            @Override
            public CommonResult<String> upUserPortrait(String userInfo, MultipartFile fil) {
                return CommonResult.failed("上传失败");
            }

            @Override
            public CommonResult<String> addAccount(AddAccountRequest addAccountRequest) {
                return CommonResult.failed("创建失败");
            }

            @Override
            public CommonResult<String> addFollow(String userInfo, Long fid) {
                return CommonResult.failed("添加失败");
            }

            @Override
            public CommonResult<List<FollowResponse>> getFollow(String userInfo) {
                return CommonResult.failed("获取失败");
            }

            @Override
            public CommonResult<String> cancelFollow(String userInfo, Long fid) {
                return CommonResult.failed("取消失败");
            }

            @Override
            public CommonResult<String> getPhone(String userInfo, String phone, String captcha) {
                return CommonResult.failed("更新失败");
            }
        };
    }
}
