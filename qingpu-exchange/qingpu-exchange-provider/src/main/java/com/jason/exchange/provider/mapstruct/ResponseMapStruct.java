package com.jason.exchange.provider.mapstruct;

import com.jason.exchange.api.response.CoinExchangeAccountPerResponse;
import com.jason.exchange.api.response.CoinExchangeAccountResponse;
import com.jason.exchange.api.response.CoinExchangeResponse;
import com.jason.exchange.biz.bo.CoinExchangeAccountBo;
import com.jason.exchange.biz.bo.CoinExchangeAccountPerBo;
import com.jason.exchange.biz.bo.CoinExchangeBo;
import com.jason.exchange.biz.mapstruct.CoinExchangeMapStruct;
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

    CoinExchangeResponse exchangeBo2Response(CoinExchangeBo exchangeBo);

    List<CoinExchangeResponse> exchangeBoList2ResponseList(List<CoinExchangeBo> exchangeBoList);

    @Mappings({
            @Mapping(target = "coinExchangeResponse", source = "coinExchangeAccountBo.coinExchangeBo"),
            @Mapping(target = "coinExchangeAccountPerResponse", source = "coinExchangeAccountBo.coinExchangeAccountPerBo"),
    })
    CoinExchangeAccountResponse coinExchangeAccountBo2Response(CoinExchangeAccountBo coinExchangeAccountBo);

    List<CoinExchangeAccountResponse> coinExchangeAccountBoList2ResponseList(List<CoinExchangeAccountBo> coinExchangeAccountBoList);

    CoinExchangeAccountPerResponse coinExchangeAccountPerBo2Response(CoinExchangeAccountPerBo coinExchangeAccountPerBo);
}
