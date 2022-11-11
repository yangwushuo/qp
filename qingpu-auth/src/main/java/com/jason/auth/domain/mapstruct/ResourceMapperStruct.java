package com.jason.auth.domain.mapstruct;

import com.jason.auth.domain.dto.ResourceDto;
import com.jason.auth.domain.po.ResourcePo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author：yangwushuo
 * @time：2022/10/30 14:50
 */
@Mapper(componentModel = "spring",uses = {UserMapperStruct.class})
public interface ResourceMapperStruct {

    ResourceMapperStruct INSTANCE = Mappers.getMapper(ResourceMapperStruct.class);

    @Mapping(source = "resourcePo.rolePos", target = "roleDtos")
    ResourceDto resourcePo2ResourceDto(ResourcePo resourcePo);

    List<ResourceDto> resourcePoList2ResourceDtoList(List<ResourcePo> resourcePos);
}
