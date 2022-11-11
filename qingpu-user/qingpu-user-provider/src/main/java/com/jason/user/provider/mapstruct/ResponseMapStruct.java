package com.jason.user.provider.mapstruct;

import com.jason.user.biz.bo.*;
import com.jason.user.biz.po.FollowPo;
import com.qingpu.user.api.request.AddAccountRequest;
import com.qingpu.user.api.request.UpUserInfoRequest;
import com.qingpu.user.api.response.FollowResponse;
import com.qingpu.user.api.response.RoleResponse;
import com.qingpu.user.api.response.UserInfoResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author：yangwushuo
 * @time：2022/11/3 11:55
 */
@Mapper(componentModel = "spring")
public interface ResponseMapStruct {

    ResponseMapStruct INSTANCE = Mappers.getMapper(ResponseMapStruct.class);

    UserInfoResponse userInfoBo2UserInfoResponse(UserInfoBo userInfoBo);

    RoleResponse roleBo2RoleResponse(RoleBo roleBo);

    List<RoleResponse> roleBoList2RoleResponseList(List<RoleBo> roleBos);

    UpUserInfoBo upUserInfoRequest2UpUserInfoBo(UpUserInfoRequest upUserInfoRequest);

    AddAccountBo addAccountRequest2AddAccountBo(AddAccountRequest addAccountRequest);

    FollowResponse followBo2FollowResponse(FollowBo followBo);

    List<FollowResponse> followBoList2FollowResponseList(List<FollowBo> followBos);

}
