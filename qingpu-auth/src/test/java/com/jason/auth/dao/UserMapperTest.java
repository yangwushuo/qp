package com.jason.auth.dao;

import com.jason.auth.domain.dto.UserDto;
import com.jason.auth.domain.mapstruct.UserMapperStruct;
import com.jason.auth.domain.po.UserPo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.core.AutoConfigureCache;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author：yangwushuo
 * @time：2022/10/29 15:42
 */
@SpringBootTest
class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserMapperStruct userMapperStruct;

    @Test
    void getUserInfo() {
        UserPo userPo = userMapper.getUserInfo(2, "1197414647@qq.com");
        UserDto userDto = userMapperStruct.userPo2UserDto(userPo);
        System.out.println(userDto);
    }
}