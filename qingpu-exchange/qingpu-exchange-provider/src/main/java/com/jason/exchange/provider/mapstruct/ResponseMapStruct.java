package com.jason.exchange.provider.mapstruct;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author：yangwushuo
 * @time：2022/11/17 19:23
 */
@Mapper(componentModel = "spring")
public interface ResponseMapStruct {

    ResponseMapStruct INSTANCE = Mappers.getMapper(ResponseMapStruct.class);
}
