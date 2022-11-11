package com.jason.auth.redis;

import com.jason.auth.constant.RedisConstant;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * @author：yangwushuo
 * @time：2022/10/30 18:46
 */
@SpringBootTest
public class redisTest {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Test
    void deleteTest(){
        Boolean delRes = redisTemplate.delete(RedisConstant.RESOURCE_ROLES_MAP);
        System.out.println(delRes);
    }

}
