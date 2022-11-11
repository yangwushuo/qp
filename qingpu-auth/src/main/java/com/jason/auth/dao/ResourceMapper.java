package com.jason.auth.dao;

import com.jason.auth.domain.dto.RoleDto;
import com.jason.auth.domain.po.ResourcePo;
import com.jason.auth.domain.po.RolePo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author：yangwushuo
 * @time：2022/10/30 14:12
 */
@Mapper
public interface ResourceMapper {

    List<ResourcePo> getAllResource();

}
