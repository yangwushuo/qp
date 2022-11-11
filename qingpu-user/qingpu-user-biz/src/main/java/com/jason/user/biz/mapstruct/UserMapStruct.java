package com.jason.user.biz.mapstruct;

import com.jason.user.biz.bo.AddAccountBo;
import com.jason.user.biz.bo.FollowBo;
import com.jason.user.biz.bo.UpUserInfoBo;
import com.jason.user.biz.bo.UserInfoBo;
import com.jason.user.biz.po.AddAccountPo;
import com.jason.user.biz.po.FollowPo;
import com.jason.user.biz.po.UpUserInfoPo;
import com.jason.user.biz.po.UserInfoPo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author：yangwushuo
 * @time：2022/11/1 22:09
 */
@Mapper(componentModel = "spring")
public interface UserMapStruct {

    UserMapStruct INSTANCE = Mappers.getMapper(UserMapStruct.class);

    UserInfoBo userInfoPo2UserInfoBo(UserInfoPo userInfoPo);

    UpUserInfoPo upUserInfoBo2UpUserInfoPo(UpUserInfoBo upUserInfoBo);

    AddAccountPo addAccountBo2AddAccountPo(AddAccountBo addAccountBo);

    FollowBo followPo2FollowBo(FollowPo followPo);

    List<FollowBo> followPoList2FollowBoList(List<FollowPo> followPos);

}
