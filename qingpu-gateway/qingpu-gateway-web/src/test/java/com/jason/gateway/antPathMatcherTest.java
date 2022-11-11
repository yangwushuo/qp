package com.jason.gateway;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.AntPathMatcher;

/**
 * @author：yangwushuo
 * @time：2022/10/31 20:04
 */
@SpringBootTest
public class antPathMatcherTest {

    @Autowired
    private AntPathMatcher antPathMatcher;

    @Test
    void matchTest(){
        String path = "/user/demo/1";
        boolean match = antPathMatcher.match("/user/demo/", path);
        System.out.println(match);
    }


}
