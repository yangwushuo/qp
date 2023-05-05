package com.jason.exchange.provider.mapstruct;

import com.jason.exchange.api.request.QuarterRequest;
import com.jason.exchange.biz.bo.QuarterBo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author：yangwushuo
 * @time：2022/11/21 14:49
 */
@Mapper(componentModel = "spring")
public interface RequestMapStruct {

    RequestMapStruct INSTANCE = Mappers.getMapper(RequestMapStruct.class);

    QuarterBo quarterRequest2Bo(QuarterRequest quarterRequest);

}
