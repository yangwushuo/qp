package com.jason.exchange.biz.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jason.binance.api.request.BinanceParamRequest;
import com.jason.binance.api.service.BinanceMarketRemoteService;
import com.jason.binance.api.service.BinanceSpotRemoteService;
import com.jason.common.Result.CommonResult;
import com.jason.common.exception.GetException;
import com.jason.exchange.biz.dao.ExchangeDao;
import com.jason.exchange.biz.po.CoinExchangeAccountKeyPo;
import com.jason.exchange.biz.service.BinanceExchangeService;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;

/**
 * @author：yangwushuo
 * @time：2022/12/1 10:42
 */
@Service
public class BinanceExchangeServiceImpl implements BinanceExchangeService {

    private final ExchangeDao exchangeDao;

    private final BinanceSpotRemoteService binanceSpotRemoteService;

    private final BinanceMarketRemoteService binanceMarketRemoteService;

    public BinanceExchangeServiceImpl(ExchangeDao exchangeDao, BinanceSpotRemoteService binanceRemoteService, BinanceMarketRemoteService binanceMarketRemoteService) {
        this.exchangeDao = exchangeDao;
        this.binanceSpotRemoteService = binanceRemoteService;
        this.binanceMarketRemoteService = binanceMarketRemoteService;
    }

    @Override
    public Object getBinanceSpotAccountInfo(Long userId, Long exAccId) {
        if (userId == null || userId < 0 || exAccId == null || exAccId < 0){
            throw new GetException("参数错误,获取失败");
        }

        CoinExchangeAccountKeyPo coinExchangeAccountKey = exchangeDao.getCoinExchangeAccountKeyById(userId, exAccId);
        BinanceParamRequest binanceParamRequest = BinanceParamRequest.builder()
                .apiKey(coinExchangeAccountKey.getApiKey())
                .secretKey(coinExchangeAccountKey.getSecretKey())
                .build();

        CommonResult<String> remoteRes = binanceSpotRemoteService.spotAccountInfo(binanceParamRequest);
        if (remoteRes.getCode() != 200){
            throw new GetException(remoteRes.getMessage());
        }

        return JSONObject.parse(remoteRes.getData());
    }

    @Override
    public Object getBinanceSpotOrders(Long userId, Long exAccId, String symbol, Long orderId, Long startTime, Long endTime, Integer limit) {
        if (userId == null || userId < 0 || exAccId == null || exAccId < 0){
            throw new GetException("参数错误,获取失败");
        }

        CoinExchangeAccountKeyPo coinExchangeAccountKey = exchangeDao.getCoinExchangeAccountKeyById(userId, exAccId);
        BinanceParamRequest binanceParamRequest = BinanceParamRequest.builder()
                .apiKey(coinExchangeAccountKey.getApiKey())
                .secretKey(coinExchangeAccountKey.getSecretKey())
                .build();
        LinkedHashMap<String, Object> params = new LinkedHashMap<>();
        if (symbol != null) params.put("symbol", symbol);
        if (orderId != null) params.put("orderId", orderId);
        if (startTime != null)params.put("startTime", startTime);
        if (endTime != null)params.put("endTime", endTime);
        if (limit != null)params.put("limit",limit);
        binanceParamRequest.setParams(params);

        CommonResult<String> remoteRes = binanceSpotRemoteService.spotAllOrders(binanceParamRequest);
        if (remoteRes.getCode() != 200){
            throw new GetException(remoteRes.getMessage());
        }

        return JSONObject.parse(remoteRes.getData());

    }

    @Override
    public Object getBinanceSpotOpenOrders(Long userId, Long exAccId, String symbol) {
        if (userId == null || userId < 0 || exAccId == null || exAccId < 0){
            throw new GetException("参数错误,获取失败");
        }

        CoinExchangeAccountKeyPo coinExchangeAccountKey = exchangeDao.getCoinExchangeAccountKeyById(userId, exAccId);
        BinanceParamRequest binanceParamRequest = BinanceParamRequest.builder()
                .apiKey(coinExchangeAccountKey.getApiKey())
                .secretKey(coinExchangeAccountKey.getSecretKey())
                .build();
        LinkedHashMap<String, Object> params = new LinkedHashMap<>();
        if (symbol != null) params.put("symbol", symbol);
        binanceParamRequest.setParams(params);

        CommonResult<String> remoteRes = binanceSpotRemoteService.spotOpenOrders(binanceParamRequest);
        if (remoteRes.getCode() != 200){
            throw new GetException(remoteRes.getMessage());
        }

        return JSONObject.parse(remoteRes.getData());
    }

    @Override
    public Object getBinanceSpotOcoOrders(Long userId, Long exAccId, Long fromId, Long startTime, Long endTime, Integer limit) {
        if (userId == null || userId < 0 || exAccId == null || exAccId < 0){
            throw new GetException("参数错误,获取失败");
        }

        CoinExchangeAccountKeyPo coinExchangeAccountKey = exchangeDao.getCoinExchangeAccountKeyById(userId, exAccId);
        BinanceParamRequest binanceParamRequest = BinanceParamRequest.builder()
                .apiKey(coinExchangeAccountKey.getApiKey())
                .secretKey(coinExchangeAccountKey.getSecretKey())
                .build();
        LinkedHashMap<String, Object> params = new LinkedHashMap<>();
        if (fromId != null) params.put("fromId", fromId);
        if (startTime != null) params.put("startTime", startTime);
        if (endTime != null) params.put("endTime", endTime);
        if (limit != null) params.put("limit", limit);
        binanceParamRequest.setParams(params);

        CommonResult<String> remoteRes = binanceSpotRemoteService.spotOcoOrders(binanceParamRequest);
        if (remoteRes.getCode() != 200){
            throw new GetException(remoteRes.getMessage());
        }

        return JSONObject.parse(remoteRes.getData());
    }

    @Override
    public Object getBinanceSpotOpenOcoOrders(Long userId, Long exAccId) {
        if (userId == null || userId < 0 || exAccId == null || exAccId < 0){
            throw new GetException("参数错误,获取失败");
        }

        CoinExchangeAccountKeyPo coinExchangeAccountKey = exchangeDao.getCoinExchangeAccountKeyById(userId, exAccId);
        BinanceParamRequest binanceParamRequest = BinanceParamRequest.builder()
                .apiKey(coinExchangeAccountKey.getApiKey())
                .secretKey(coinExchangeAccountKey.getSecretKey())
                .params(new LinkedHashMap<>())
                .build();

        CommonResult<String> remoteRes = binanceSpotRemoteService.spotOpenOcoOrders(binanceParamRequest);
        if (remoteRes.getCode() != 200){
            throw new GetException(remoteRes.getMessage());
        }

        return JSONObject.parse(remoteRes.getData());
    }

    @Override
    public Object getBinanceSpotTrades(Long userId, Long exAccId, String symbol, Long orderId, Long startTime, Long endTime, Long fromId, Integer limit) {
        if (userId == null || userId < 0 || exAccId == null || exAccId < 0){
            throw new GetException("参数错误,获取失败");
        }

        CoinExchangeAccountKeyPo coinExchangeAccountKey = exchangeDao.getCoinExchangeAccountKeyById(userId, exAccId);
        BinanceParamRequest binanceParamRequest = BinanceParamRequest.builder()
                .apiKey(coinExchangeAccountKey.getApiKey())
                .secretKey(coinExchangeAccountKey.getSecretKey())
                .build();
        LinkedHashMap<String, Object> params = new LinkedHashMap<>();
        if (symbol != null) params.put("symbol", symbol);
        if (orderId != null) params.put("orderId", orderId);
        if (startTime != null) params.put("startTime", startTime);
        if (endTime != null) params.put("endTime", endTime);
        if (fromId != null) params.put("fromId", fromId);
        if (limit != null) params.put("limit", limit);
        binanceParamRequest.setParams(params);

        CommonResult<String> remoteRes = binanceSpotRemoteService.spotTrades(binanceParamRequest);
        if (remoteRes.getCode() != 200){
            throw new GetException(remoteRes.getMessage());
        }

        return JSONObject.parse(remoteRes.getData());
    }

    @Override
    public Object getBinanceSpotRateLimitOrder(Long userId, Long exAccId) {
        if (userId == null || userId < 0 || exAccId == null || exAccId < 0){
            throw new GetException("参数错误,获取失败");
        }

        CoinExchangeAccountKeyPo coinExchangeAccountKey = exchangeDao.getCoinExchangeAccountKeyById(userId, exAccId);
        BinanceParamRequest binanceParamRequest = BinanceParamRequest.builder()
                .apiKey(coinExchangeAccountKey.getApiKey())
                .secretKey(coinExchangeAccountKey.getSecretKey())
                .params(new LinkedHashMap<>())
                .build();

        CommonResult<String> remoteRes = binanceSpotRemoteService.spotRateLimitOrder(binanceParamRequest);
        if (remoteRes.getCode() != 200){
            throw new GetException(remoteRes.getMessage());
        }

        return JSONObject.parse(remoteRes.getData());
    }

    @Override
    public Object binanceMarketPing() {
        CommonResult<String> remoteRes = binanceMarketRemoteService.marketPing();
        if (remoteRes.getCode() != 200){
            throw new GetException(remoteRes.getMessage());
        }

        return JSONObject.parse(remoteRes.getData());
    }

}
