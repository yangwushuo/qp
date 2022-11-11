package com.jason.test;

import com.jason.user.biz.bo.UserInfoBo;
import com.jason.user.biz.mapper.UserMapper;
import com.jason.user.biz.po.RolePo;
import com.jason.user.biz.po.UpUserInfoPo;
import com.jason.user.biz.po.UserInfoPo;
import com.jason.user.biz.service.UserService;
import com.jason.user.provider.QinpuUserProviderApp;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @author：yangwushuo
 * @time：2022/11/2 15:13
 */
@SpringBootTest(classes = QinpuUserProviderApp.class)
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    void getUserInfoTest(){
        UserInfoPo userInfoPo = userMapper.getUserInfo(12341243L);
        System.out.println(userInfoPo);
    }

    @Test
    void getUserRoleByIdTest(){
        List<RolePo> rolePos = userMapper.getUserRoleById(12341243L);
        System.out.println(rolePos);
    }

    @Test
    void upUserInfoTest(){
        UpUserInfoPo upUserInfoPo = UpUserInfoPo.builder()
                .username("小杨")
                .build();
        userMapper.upUserInfoById(12341244L, upUserInfoPo);
    }

}
