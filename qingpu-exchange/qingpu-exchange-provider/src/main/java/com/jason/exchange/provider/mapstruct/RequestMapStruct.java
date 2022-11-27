package com.jason.exchange.provider.mapstruct;

import com.jason.exchange.api.request.AddCoinExchangeAccountRequest;
import com.jason.exchange.api.request.UpCoinExchangeAccountRequest;
import com.jason.exchange.biz.bo.AddCoinExchangeAccountBo;
import com.jason.exchange.biz.bo.UpCoinExchangeAccountBo;
import com.jason.exchange.biz.mapstruct.CoinExchangeMapStruct;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author：yangwushuo
 * @time：2022/11/21 14:49
 */
@Mapper(componentModel = "spring")
public interface RequestMapStruct {

    RequestMapStruct INSTANCE = Mappers.getMapper(RequestMapStruct.class);

    UpCoinExchangeAccountBo upCoinExchangeAccountRequest2Bo(UpCoinExchangeAccountRequest upCoinExchangeAccountRequest);

    AddCoinExchangeAccountBo addCoinExchangeAccountRequest2Bo(AddCoinExchangeAccountRequest addCoinExchangeAccountRequest);
}
