package com.qingpu.user.api.service;

import com.jason.common.Result.CommonResult;
import com.qingpu.user.api.fallback.UserRemoteServiceFallbackFactory;
import com.qingpu.user.api.request.AddAccountRequest;
import com.qingpu.user.api.request.UpUserInfoRequest;
import com.qingpu.user.api.response.FollowResponse;
import com.qingpu.user.api.response.UserInfoResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * 用户REST接口
 * @author：yangwushuo
 * @time：2022/10/26 10:50
 */
@FeignClient(name = "qingpu-user-provider", fallbackFactory = UserRemoteServiceFallbackFactory.class)
public interface UserRemoteService {

    /**
     * @param userInfo
     * @return CommonResult<UserInfoResponse>
     * @author yangwushuo
     * @description TODO 获取用户信息
     * @date 2022/10/26 10:59
     */
    @GetMapping("/user/get_info")
    CommonResult<UserInfoResponse> getUserInfo(@RequestHeader("user")String userInfo);

    /**
     * @return CommonResult<String>
     * @Author yangwushuo
     * @Decription //TODO 更新用户信息
     * @Date 14:38 2022/11/3
     * @Param upUserInfoRequest
     **/
    @PutMapping("/user/up_info")
    CommonResult<String> upUserInfo(@RequestHeader("user")String userInfo, @RequestBody UpUserInfoRequest upUserInfoRequest);

    /**
     * @return CommonResult<String>
     * @Author yangwushuo
     * @Decription //TODO 更新用户头像
     * @Date 19:37 2022/11/4
     * @Param
     **/
    @PutMapping("/user/up_portrait")
    CommonResult<String> upUserPortrait(@RequestHeader("user")String userInfo, @RequestParam("file") MultipartFile file);

    /**
     * @return CommonResult<String>
     * @Author yangwushuo
     * @Decription //TODO 创建账户
     * @Date 14:17 2022/11/6
     * @Param
     **/
    @PostMapping("/user/add_account")
    CommonResult<String> addAccount(@RequestBody AddAccountRequest addAccountRequest);


    /**
     * @return CommonResult<String>
     * @Author yangwushuo
     * @Decription //TODO 添加关注
     * @Date 14:27 2022/11/7
     * @Param
     **/
    @PostMapping("/user/add_follow")
    CommonResult<String> addFollow(@RequestHeader("user")String userInfo, @RequestParam("fid") Long fid);

    /**
     * @return CommonResult<FollowResponse>
     * @Author yangwushuo
     * @Decription //TODO 获取用户关注列表
     * @Date 17:23 2022/11/9
     * @Param
     **/
    @GetMapping("/user/get_follow")
    CommonResult<List<FollowResponse>> getFollow(@RequestHeader("user")String userInfo);

    /**
     * @return CommonResult<String>
     * @Author yangwushuo
     * @Decription //TODO 取消关注
     * @Date 16:04 2022/11//10
     * @Param
     **/
    @DeleteMapping("/user/cancel_follow")
    CommonResult<String> cancelFollow(@RequestHeader("user")String userInfo, @RequestParam("fid") Long fid);

}
