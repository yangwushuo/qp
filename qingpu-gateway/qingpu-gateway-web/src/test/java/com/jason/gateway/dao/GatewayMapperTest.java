package com.jason.gateway.dao;

import com.jason.gateway.domain.dto.IgnoreUrlDto;
import com.jason.gateway.domain.mapstruct.GatewayMapperStruct;
import com.jason.gateway.domain.po.IgnoreUrlPo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;

/**
 * @author：yangwushuo
 * @time：2022/10/30 20:00
 */
@SpringBootTest
class GatewayMapperTest {

    @Autowired
    private GatewayMapper gatewayMapper;

    @Autowired
    private GatewayMapperStruct gatewayMapperStruct;

    @Test
    void getAllIgnoreUrls() {
        List<IgnoreUrlPo> allIgnoreUrls = gatewayMapper.getAllIgnoreUrls();
        List<IgnoreUrlDto> ignoreUriDtos = gatewayMapperStruct.ignoreUriPoList2IgnoreUriDtoList(allIgnoreUrls);
        System.out.println(ignoreUriDtos);
    }
}