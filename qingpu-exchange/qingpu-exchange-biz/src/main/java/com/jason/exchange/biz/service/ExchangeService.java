package com.jason.exchange.biz.service;

import com.jason.common.Result.CommonResult;
import com.jason.exchange.biz.bo.AddCoinExchangeAccountBo;
import com.jason.exchange.biz.bo.CoinExchangeAccountBo;
import com.jason.exchange.biz.bo.CoinExchangeBo;
import com.jason.exchange.biz.bo.UpCoinExchangeAccountBo;

import java.util.LinkedHashMap;
import java.util.List;

/**
 * @author：yangwushuo
 * @time：2022/11/17 15:01
 */
public interface ExchangeService {

    List<CoinExchangeBo> getAllCoinExchange();

    List<CoinExchangeAccountBo> getCoinExchangeAccount(Long userId, Long exId);

    void upCoinExchangeAccount(Long userId, UpCoinExchangeAccountBo upCoinExchangeAccountBo);

    void delCoinExchangeAccount(Long userId, Long exAccId);

    void addCoinExchangeAccount(Long userId, AddCoinExchangeAccountBo addCoinExchangeAccountBo);

    Object getBinanceSpotAccountInfo(Long userId, Long exAccId);

    Object getBinanceSpotOrders(Long userId, Long exAccId, String symbol, Long orderId, Long startTime, Long endTime, Integer limit);

    Object getBinanceSpotOpenOrders(Long userId, Long exAccId, String symbol);

    Object getBinanceSpotOcoOrders(Long userId, Long exAccId, Long fromId, Long startTime, Long endTime, Integer limit);

    Object getBinanceSpotOpenOcoOrders(Long userId, Long exAccId);
}
