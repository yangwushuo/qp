package com.jason.exchange.api.fallback;

import com.jason.common.Result.CommonResult;
import com.jason.exchange.api.request.AddCoinExchangeAccountRequest;
import com.jason.exchange.api.request.UpCoinExchangeAccountRequest;
import com.jason.exchange.api.response.CoinExchangeAccountResponse;
import com.jason.exchange.api.response.CoinExchangeResponse;
import com.jason.exchange.api.service.ExchangeRemoteService;
import org.springframework.cloud.openfeign.FallbackFactory;

import java.util.List;

/**
 * @author：yangwushuo
 * @time：2022/11/17 14:15
 */
public class ExchangeRemoteServiceFallbackFactory implements FallbackFactory<ExchangeRemoteService> {
    @Override
    public ExchangeRemoteService create(Throwable cause) {
        return new ExchangeRemoteService() {
            @Override
            public CommonResult<List<CoinExchangeResponse>> allCoinExchange() {
                return CommonResult.failed("获取失败");
            }
            @Override
            public CommonResult<List<CoinExchangeAccountResponse>> getUserCoinExchangeAccount(Long userId, Long exId) {
                return CommonResult.failed("获取失败");
            }

            @Override
            public CommonResult<String> addUserCoinExchangeAccount(String userInfo, AddCoinExchangeAccountRequest addCoinExchangeAccountRequest) {
                return CommonResult.failed("添加失败");
            }

            @Override
            public CommonResult<String> upUserCoinExchangeAccount(String userInfo, UpCoinExchangeAccountRequest upCoinExchangeAccountRequest) {
                return CommonResult.failed("更新失败");
            }

            @Override
            public CommonResult<String> delUserCoinExchangeAccount(String userInfo, Long exAccId) {
                return CommonResult.failed("删除失败");
            }

            @Override
            public CommonResult<Object> getUserBinanceSpotAccountInfo(String userInfo, Long exAccId) {
                return CommonResult.failed("获取失败");
            }

            @Override
            public CommonResult<Object> getUserBinanceSpotOrders(String userInfo, Long exAccId, String symbol, Long orderId, Long startTime, Long endTime, Integer limit) {
                return CommonResult.failed("获取失败");
            }

            @Override
            public CommonResult<Object> getUserBinanceSpotOpenOrders(String userInfo, Long exAccId, String symbol) {
                return CommonResult.failed("获取失败");
            }

            @Override
            public CommonResult<Object> getUserBinanceSpotOcoOrders(String userInfo, Long exAccId, Long fromId, Long startTime, Long endTime, Integer limit) {
                return CommonResult.failed("获取失败");
            }

            @Override
            public CommonResult<Object> getUserBinanceSpotOpenOcoOrders(String userInfo, Long exAccId) {
                return CommonResult.failed("获取失败");
            }
        };
    }
}
