package com.jason.user.provider.service;

import com.jason.common.Result.CommonResult;
import com.jason.common.entity.HeaderUserInfo;
import com.jason.common.util.JsonToObject;
import com.jason.user.biz.bo.AddAccountBo;
import com.jason.user.biz.bo.FollowBo;
import com.jason.user.biz.bo.UpUserInfoBo;
import com.jason.user.biz.bo.UserInfoBo;
import com.jason.user.biz.service.OssService;
import com.jason.user.biz.service.UserService;
import com.jason.user.provider.mapstruct.ResponseMapStruct;
import com.qingpu.user.api.request.AddAccountRequest;
import com.qingpu.user.api.request.UpUserInfoRequest;
import com.qingpu.user.api.response.FollowResponse;
import com.qingpu.user.api.response.UserInfoResponse;
import com.qingpu.user.api.service.UserRemoteService;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@Api(tags = "用户接口")
public class UserRemoteServiceImpl implements UserRemoteService {

    private final UserService userService;

    private final ResponseMapStruct responseMapStruct;

    private final OssService ossService;

    public UserRemoteServiceImpl(UserService userService, ResponseMapStruct responseMapStruct, OssService ossService) {
        this.userService = userService;
        this.responseMapStruct = responseMapStruct;
        this.ossService = ossService;
    }

    @Override
    @ApiOperation(value ="获取用户信息", notes = "ROLE:ADMIN,USER,BOSS")
//    @ApiImplicitParam(paramType = "header", name = "userInfo", value = "头部用户信息", required = true)
    @ApiResponses({
            @ApiResponse(code = 200, message = "获取成功"),
            @ApiResponse(code = 500, message = "获取失败")
    })
    public CommonResult<UserInfoResponse> getUserInfo(String userInfo) {
        HeaderUserInfo headerUserInfo = JsonToObject.jsonToClass(userInfo, HeaderUserInfo.class);
        UserInfoBo userInfoBo = userService.getUserInfo(headerUserInfo.getId());
        return CommonResult.success(responseMapStruct.userInfoBo2UserInfoResponse(userInfoBo));
    }

    @Override
    @ApiOperation(value ="更新用户信息", notes = "ROLE:ADMIN,USER,BOSS")
    @ApiImplicitParam(paramType = "body", name = "upUserInfoRequest", value = "更新用户请求体", required = true)
    @ApiResponses({
            @ApiResponse(code = 200, message = "更新成功"),
            @ApiResponse(code = 500, message = "更新失败")
    })
    public CommonResult<String> upUserInfo(String userInfo, UpUserInfoRequest upUserInfoRequest) {
        HeaderUserInfo headerUserInfo = JsonToObject.jsonToClass(userInfo, HeaderUserInfo.class);
        UpUserInfoBo upUserInfoBo = responseMapStruct.upUserInfoRequest2UpUserInfoBo(upUserInfoRequest);
        userService.upUserInfo(headerUserInfo.getId(),upUserInfoBo);
        return CommonResult.success("更新成功");
    }

    @Override
    @ApiOperation(value ="上传用户头像", notes = "ROLE:ADMIN,USER,BOSS")
    @ApiImplicitParam(paramType = "body", name = "file", value = "头像文件", required = true)
    @ApiResponses({
            @ApiResponse(code = 200, message = "上传成功"),
            @ApiResponse(code = 500, message = "上床失败")
    })
    public CommonResult<String> upUserPortrait(String userInfo, MultipartFile file) {
        HeaderUserInfo headerUserInfo = JsonToObject.jsonToClass(userInfo, HeaderUserInfo.class);
        userService.upUserPortrait(headerUserInfo.getId(), file);
        return CommonResult.success("上传成功");
    }

    @Override
    @ApiOperation(value ="创建账户", notes = "ROLE:ADMIN,USER,BOSS")
    @ApiImplicitParam(paramType = "body", name = "addAccountRequest", value = "创建账户请求体", required = true)
    @ApiResponses({
            @ApiResponse(code = 200, message = "创建成功"),
            @ApiResponse(code = 500, message = "创建失败")
    })
    public CommonResult<String> addAccount(AddAccountRequest addAccountRequest) {
        AddAccountBo addAccountBo = responseMapStruct.addAccountRequest2AddAccountBo(addAccountRequest);
        userService.addAccount(addAccountBo);
        return CommonResult.success("创建成功");
    }

    @Override
    @ApiOperation(value ="添加关注", notes = "ROLE:ADMIN,USER,BOSS")
    @ApiImplicitParam(paramType = "query", name = "fid", value = "关注id", required = true)
    @ApiResponses({
            @ApiResponse(code = 200, message = "关注成功"),
            @ApiResponse(code = 500, message = "关注失败")
    })
    public CommonResult<String> addFollow(String userInfo, Long fid) {
        HeaderUserInfo headerUserInfo = JsonToObject.jsonToClass(userInfo, HeaderUserInfo.class);
        userService.addFollow(headerUserInfo.getId(), fid);
        return CommonResult.success("关注成功");
    }

    @Override
    @ApiOperation(value ="获取关注列表", notes = "ROLE:ADMIN,USER,BOSS")
//    @ApiImplicitParam(paramType = "query", name = "fid", value = "关注id", required = true)
    @ApiResponses({
            @ApiResponse(code = 200, message = "获取成功"),
            @ApiResponse(code = 500, message = "获取失败")
    })
    public CommonResult<List<FollowResponse>> getFollow(String userInfo) {
        HeaderUserInfo headerUserInfo = JsonToObject.jsonToClass(userInfo, HeaderUserInfo.class);
        List<FollowBo> followBos = userService.getFollow(headerUserInfo.getId());
        List<FollowResponse> followResponses = responseMapStruct.followBoList2FollowResponseList(followBos);
        return CommonResult.success(followResponses);
    }

    @Override
    @ApiOperation(value ="取消关注", notes = "ROLE:ADMIN,USER,BOSS")
    @ApiImplicitParam(paramType = "query", name = "fid", value = "取消关注id", required = true)
    @ApiResponses({
            @ApiResponse(code = 200, message = "取消成功"),
            @ApiResponse(code = 500, message = "取消失败")
    })
    public CommonResult<String> cancelFollow(String userInfo, Long fid) {
        HeaderUserInfo headerUserInfo = JsonToObject.jsonToClass(userInfo, HeaderUserInfo.class);
        userService.cancelFollow(headerUserInfo.getId(), fid);
        return CommonResult.success("取消成功");
    }

    @Override
    @ApiOperation(value ="更新手机号", notes = "ROLE:ADMIN,USER,BOSS")
    @ApiImplicitParams({
        @ApiImplicitParam(paramType = "query", name = "phone", value = "手机号", required = true),
        @ApiImplicitParam(paramType = "query", name = "captcha", value = "验证码", required = true)
    })
    @ApiResponses({
            @ApiResponse(code = 200, message = "更新成功"),
            @ApiResponse(code = 500, message = "更新失败")
    })
    public CommonResult<String> upPhone(String userInfo, String phone, String captcha) {
        HeaderUserInfo headerUserInfo = JsonToObject.jsonToClass(userInfo, HeaderUserInfo.class);
        userService.upPhone(headerUserInfo.getId(), phone, captcha);
        return CommonResult.success("更新成功");
    }

    @Override
    @ApiOperation(value ="更新邮箱", notes = "ROLE:ADMIN,USER,BOSS")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "email", value = "邮箱", required = true),
            @ApiImplicitParam(paramType = "query", name = "captcha", value = "验证码", required = true)
    })
    @ApiResponses({
            @ApiResponse(code = 200, message = "更新成功"),
            @ApiResponse(code = 500, message = "更新失败")
    })
    public CommonResult<String> upEmail(String userInfo, String email, String captcha) {
        HeaderUserInfo headerUserInfo = JsonToObject.jsonToClass(userInfo, HeaderUserInfo.class);
        userService.upEmail(headerUserInfo.getId(), email, captcha);
        return CommonResult.success("更新成功");
    }

    @Override
    @ApiOperation(value ="发送验证码到绑定的手机号", notes = "ROLE:ADMIN,USER,BOSS")
    @ApiImplicitParam(paramType = "query", name = "symbol", value = "验证码标识", required = true)
    @ApiResponses({
            @ApiResponse(code = 200, message = "发送成功"),
            @ApiResponse(code = 500, message = "发送失败")
    })
    public CommonResult<String> sendPhoneCaptcha(String userInfo, Integer symbol) {
        HeaderUserInfo headerUserInfo = JsonToObject.jsonToClass(userInfo, HeaderUserInfo.class);
        userService.sendCaptcha2Phone(headerUserInfo.getId(), symbol);
        return CommonResult.success("发送成功");
    }

    @Override
    @ApiOperation(value ="发送验证码到绑定的邮箱", notes = "ROLE:ADMIN,USER,BOSS")
    @ApiImplicitParam(paramType = "query", name = "symbol", value = "验证码标识", required = true)
    @ApiResponses({
            @ApiResponse(code = 200, message = "发送成功"),
            @ApiResponse(code = 500, message = "发送失败")
    })
    public CommonResult<String> sendEmailCaptcha(String userInfo, Integer symbol) {
        HeaderUserInfo headerUserInfo = JsonToObject.jsonToClass(userInfo, HeaderUserInfo.class);
        userService.sendCaptcha2Email(headerUserInfo.getId(), symbol);
        return CommonResult.success("发送成功");
    }


}