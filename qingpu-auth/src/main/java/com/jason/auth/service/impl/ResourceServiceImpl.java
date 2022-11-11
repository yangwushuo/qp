package com.jason.auth.service.impl;

import cn.hutool.core.collection.CollUtil;
import com.jason.auth.constant.RedisConstant;
import com.jason.auth.dao.ResourceMapper;
import com.jason.auth.domain.dto.ResourceDto;
import com.jason.auth.domain.mapstruct.ResourceMapperStruct;
import com.jason.auth.service.ResourceService;
import lombok.AllArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * 资源与角色匹配关系管理业务类
 * @author: yangwushuo
 * @time: 2022/10/27 11:31
 */
@Service
@AllArgsConstructor
public class ResourceServiceImpl implements ResourceService {

  private final RedisTemplate<String, Object> redisTemplate;

  private final ResourceMapper resourceMapper;

  private final ResourceMapperStruct resourceMapperStruct;


  @PostConstruct
  public void initData() {

    //数据库中获取所有路径
    List<ResourceDto> resourceDtos = resourceMapperStruct.resourcePoList2ResourceDtoList(resourceMapper.getAllResource());

    if(resourceDtos != null && resourceDtos.size() > 0 ){

      //清空redis key 的数据
      redisTemplate.delete(RedisConstant.RESOURCE_ROLES_MAP);

      Map<String, List<String>> resourceRolesMap = new TreeMap<>();

      resourceDtos.stream().forEach( resourceDto -> {
        List<String> roleNames = new ArrayList<>();
        for (int i = 0; i < resourceDto.getRoleDtos().size(); i++) {
          roleNames.add(resourceDto.getRoleDtos().get(i).getName());
        }
        resourceRolesMap.put(resourceDto.getRouteName(),roleNames);
      });

      redisTemplate.opsForHash().putAll(RedisConstant.RESOURCE_ROLES_MAP, resourceRolesMap);

    }
  }
}
