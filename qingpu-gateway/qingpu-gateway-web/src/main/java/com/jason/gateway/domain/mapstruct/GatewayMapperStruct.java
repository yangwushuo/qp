package com.jason.gateway.domain.mapstruct;

import com.jason.gateway.domain.dto.IgnoreUrlDto;
import com.jason.gateway.domain.po.IgnoreUrlPo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author：yangwushuo
 * @time：2022/10/30 19:50
 */
@Mapper(componentModel = "spring")
public interface GatewayMapperStruct {

    GatewayMapperStruct INSTANCE = Mappers.getMapper(GatewayMapperStruct.class);

    IgnoreUrlDto ignoreUriPo2IgnoreUriDto(IgnoreUrlPo ignoreUriPo);

    List<IgnoreUrlDto> ignoreUriPoList2IgnoreUriDtoList(List<IgnoreUrlPo> ignoreUriPos);

}
