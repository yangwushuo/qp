package com.jason.auth.dao;

import com.jason.auth.domain.dto.ResourceDto;
import com.jason.auth.domain.dto.RoleDto;
import com.jason.auth.domain.mapstruct.ResourceMapperStruct;
import com.jason.auth.domain.po.ResourcePo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author：yangwushuo
 * @time：2022/10/30 14:39
 */
@SpringBootTest
class ResourceMapperTest {

    @Autowired
    private ResourceMapper resourceMapper;

    @Autowired
    private ResourceMapperStruct resourceMapperStruct;

    @Test
    void getAllResource() {

        List<ResourcePo> allResource = resourceMapper.getAllResource();
        allResource.stream().forEach(System.out::println);

        List<ResourceDto> resourceDtos = resourceMapperStruct.resourcePoList2ResourceDtoList(allResource);
        resourceDtos.stream().forEach(System.out::println);

    }
}