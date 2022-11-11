package com.jason.user.biz.dao;

import com.jason.user.biz.po.AddAccountPo;
import com.jason.user.biz.po.FollowPo;
import com.jason.user.biz.po.UpUserInfoPo;
import com.jason.user.biz.po.UserInfoPo;

import java.util.List;

/**
 * @author：yangwushuo
 * @time：2022/11/1 21:43
 */
public interface UserDao {

    /**
     * @return a
     * @Author yangwushuo
     * @Decription //TODO 获取用户信息
     * @Date 15:18 2022/11/3
     * @Param
     **/
    UserInfoPo getUserInfo(Long id);

    Integer getUserAmount(Long id);

    Long getRoleIdByName(String roleName);

    void upUserInfo(Long id, UpUserInfoPo userInfoPo);

    void addAccount(AddAccountPo addAccountPo);

    void addAccountInfo(AddAccountPo addAccountPo);

    void addRole(Long uid, Long rid);

    void addFollow(Long uid, Long fid, Long followTime);

    List<FollowPo> getFollowUserById(Long uid, Long fid);

    void delFollow(Long uid, Long fid);


}
