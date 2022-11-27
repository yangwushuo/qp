package com.jason.user.biz.dao.impl;


import com.jason.user.biz.dao.UserDao;
import com.jason.user.biz.mapper.UserMapper;
import com.jason.user.biz.po.AddAccountPo;
import com.jason.user.biz.po.FollowPo;
import com.jason.user.biz.po.UpUserInfoPo;
import com.jason.user.biz.po.UserInfoPo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author：yangwushuo
 * @time：2022/11/1 21:19
 */
@Repository
public class UserDaoImpl implements UserDao {

    private UserMapper userMapper;

    public UserDaoImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public UserInfoPo getUserInfo(Long id) {
        UserInfoPo userInfoPo = userMapper.getUserInfo(id);
        return userInfoPo;
    }

    @Override
    public Integer getUserAmount(Long id) {
        return userMapper.getUserAmountById(id);
    }

    @Override
    public Long getRoleIdByName(String roleName) {
        return userMapper.getRoleIdByName(roleName);
    }

    @Override
    public void upUserInfo(Long id, UpUserInfoPo userInfoPo) {
        userMapper.upUserInfoById(id, userInfoPo);
    }

    @Override
    public void addAccount(AddAccountPo addAccountPo) {
        userMapper.addAccount(addAccountPo);
    }

    @Override
    public void addAccountInfo(AddAccountPo addAccountPo) {
        userMapper.addAccountInfo(addAccountPo);
    }

    @Override
    public void addRole(Long uid, Long rid) {
        userMapper.addRole(uid,rid);
    }

    @Override
    public void addFollow(Long uid, Long fid, Long followTime) {
        userMapper.addFollow(uid, fid, followTime);
    }

    @Override
    public List<FollowPo> getFollowUserById(Long uid, Long fid) {
        return userMapper.getFollowByUserId(uid, fid);
    }

    @Override
    public void delFollow(Long uid, Long fid) {
        userMapper.delFollow(uid, fid);
    }

    @Override
    public void upPhone(Long uid, String phone) {
        userMapper.upPhone(uid, phone);
    }

    @Override
    public void upEmail(Long uid, String email) {
        userMapper.upEmail(uid, email);
    }

    @Override
    public String getUserPhoneById(Long uid) {
        return userMapper.getUserPhoneById(uid);
    }

    @Override
    public String getUserEmailById(Long uid) {
        return userMapper.getUserEmailById(uid);
    }

    @Override
    public String getUserPasswordById(Long uid) {
        return userMapper.getUserPasswordById(uid);
    }

}
