package com.jason.auth.dao;

import com.jason.auth.domain.po.UserPo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author：yangwushuo
 * @time：2022/10/29 12:39
 */
@Mapper
public interface UserMapper {

    /*
     * do: 获取用户信息
     */
    public UserPo getUserInfo(@Param("flag") Integer flag, @Param("content") String content);


}
