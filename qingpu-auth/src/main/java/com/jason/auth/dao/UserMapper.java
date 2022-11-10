package com.jason.auth.dao;

import org.apache.ibatis.annotations.Mapper;

/**
 * @author：yangwushuo
 * @time：2022/10/29 12:39
 */
@Mapper
public interface UserMapper {

    getUserInfo(Integer flag, String content);


}
