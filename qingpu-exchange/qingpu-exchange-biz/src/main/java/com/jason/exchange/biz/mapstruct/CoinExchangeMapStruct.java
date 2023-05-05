package com.jason.exchange.biz.mapstruct;


import com.jason.exchange.biz.bo.QuarterBo;
import com.jason.exchange.biz.po.QuarterPo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author：yangwushuo
 * @time：2022/11/17 19:16
 */
@Mapper(componentModel = "spring")
public interface CoinExchangeMapStruct {

    CoinExchangeMapStruct INSTANCE = Mappers.getMapper(CoinExchangeMapStruct.class);

    QuarterPo quarterBo2Po(QuarterBo quarterBo);


}


