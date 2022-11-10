package com.jason.gateway.domain.mapstruct;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author：yangwushuo
 * @time：2022/10/30 19:50
 */
@Mapper(componentModel = "spring")
public interface ConfigMapperStruct {

    ConfigMapperStruct INSTANCE = Mappers.getMapper(ConfigMapperStruct.class);

}
