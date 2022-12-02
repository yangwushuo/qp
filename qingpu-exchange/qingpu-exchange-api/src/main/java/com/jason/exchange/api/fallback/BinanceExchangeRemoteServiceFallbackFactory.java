package com.jason.exchange.api.fallback;

import com.jason.common.Result.CommonResult;
import com.jason.exchange.api.service.BinanceExchangeRemoteService;
import org.springframework.cloud.openfeign.FallbackFactory;

/**
 * @author：yangwushuo
 * @time：2022/12/1 10:28
 */
public class BinanceExchangeRemoteServiceFallbackFactory implements FallbackFactory<BinanceExchangeRemoteService> {
    @Override
    public BinanceExchangeRemoteService create(Throwable cause) {
        return new BinanceExchangeRemoteService() {

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

            @Override
            public CommonResult<Object> getUserBinanceSpotTrades(String userInfo, Long exAccId, String symbol, Long orderId, Long startTime, Long endTime, Long fromId, Integer limit) {
                return CommonResult.failed("获取失败");
            }

            @Override
            public CommonResult<Object> getUserBinanceSpotRateLimitOrder(String userInfo, Long exAccId) {
                return CommonResult.failed("获取失败");
            }

            @Override
            public CommonResult<Object> getBinanceMarketPing() {
                return CommonResult.failed("获取失败");
            }
        };
    }
}
