package com.jason.auth.domain.mapstruct;


import com.jason.auth.domain.dto.RoleDto;
import com.jason.auth.domain.dto.UserDto;
import com.jason.auth.domain.po.RolePo;
import com.jason.auth.domain.po.UserPo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author：yangwushuo
 * @time：2022/10/29 16:27
 */
@Mapper(componentModel = "spring")
public interface UserMapperStruct {

    UserMapperStruct INSTANCE = Mappers.getMapper(UserMapperStruct.class);

    @Mapping(source = "userPo.rolePos", target = "roleDtos")
    UserDto userPo2UserDto(UserPo userPo);

    RoleDto rolePo2RoleDto(RolePo rolePo);
    List<RoleDto> rolePoList2RoleDtoList(List<RolePo> rolePos);

}
