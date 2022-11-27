package com.jason.exchange.biz.mapstruct;

import com.jason.exchange.biz.bo.*;
import com.jason.exchange.biz.po.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;
import org.mybatis.spring.annotation.MapperScans;

import java.util.List;

/**
 * @author：yangwushuo
 * @time：2022/11/17 19:16
 */
@Mapper(componentModel = "spring")
public interface CoinExchangeMapStruct {

    CoinExchangeMapStruct INSTANCE = Mappers.getMapper(CoinExchangeMapStruct.class);

    CoinExchangeBo coinExchangePo2Bo(CoinExchangePo coinExchangePo);

    List<CoinExchangeBo> coinExchangePoList2BoList(List<CoinExchangePo> coinExchangePoList);

    @Mappings({
            @Mapping(target = "coinExchangeBo", source = "coinExchangeAccountPo.coinExchangePo"),
            @Mapping(target = "coinExchangeAccountPerBo", source = "coinExchangeAccountPo.coinExchangeAccountPerPo")
    })
    CoinExchangeAccountBo coinExchangeAccountPo2Bo(CoinExchangeAccountPo coinExchangeAccountPo);

    List<CoinExchangeAccountBo> coinExchangeAccountPoList2BoList(List<CoinExchangeAccountPo> coinExchangeAccountPoList);

    CoinExchangeAccountPerBo coinExchangeAccountPerPo2Bo(CoinExchangeAccountPerPo coinExchangeAccountPerPo);

    UpCoinExchangeAccountPo upCoinExchangeAccountBo2Po(UpCoinExchangeAccountBo upCoinExchangeAccountBo);

    AddCoinExchangeAccountPo addCoinExchangeAccountBo2Po(AddCoinExchangeAccountBo addCoinExchangeAccountBo);
}


