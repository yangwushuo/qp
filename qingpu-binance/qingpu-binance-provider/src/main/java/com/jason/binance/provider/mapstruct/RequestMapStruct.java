package com.jason.binance.provider.mapstruct;

import com.jason.binance.api.request.BinanceParamRequest;
import com.jason.binance.biz.bo.BinanceKeyBo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author：yangwushuo
 * @time：2022/11/24 11:57
 */
@Mapper(componentModel = "spring")
public interface RequestMapStruct {

    RequestMapStruct INSTANCE = Mappers.getMapper(RequestMapStruct.class);

    BinanceKeyBo binanceKeyRequestRequest2Bo(BinanceParamRequest binanceParamRequest);

}
