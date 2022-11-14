package com.jason.user.biz.mapper;

import com.jason.user.biz.po.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author：yangwushuo
 * @time：2022/11/1 21:41
 */
@Mapper
public interface UserMapper {

    UserInfoPo getUserInfo(@Param("id") Long id);

    List<RolePo> getUserRoleById(@Param("id") Long id);

    Integer getUserAmountById(@Param("id") Long id);

    Long getRoleIdByName(@Param("roleName") String roleName);

    void upUserInfoById(@Param("id") Long id, @Param("uui") UpUserInfoPo userInfoPo);

    void addAccount(@Param("ac")AddAccountPo addAccountPo);

    void addAccountInfo(@Param("ac")AddAccountPo addAccountPo);

    void addRole(@Param("uid") Long uid, @Param("rid") Long rid);

    void addFollow(@Param("uid") Long uid, @Param("fid") Long fid, @Param("followTime") Long followTime);

    List<FollowPo> getFollowByUserId(@Param("uid") Long uid, @Param("fid") Long fid);

    void delFollow(@Param("uid") Long uid, @Param("fid") Long fid);

    void upPhone(@Param("uid") Long uid, @Param("phone") String phone);

    void upEmail(@Param("uid") Long uid, @Param("email") String email);

    String getUserPhoneById(@Param("uid") Long uid);

    String getUserEmailById(@Param("uid") Long uid);

}
