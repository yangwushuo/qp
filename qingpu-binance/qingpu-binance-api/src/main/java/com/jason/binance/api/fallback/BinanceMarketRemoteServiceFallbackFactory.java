package com.jason.binance.api.fallback;

import com.jason.binance.api.service.BinanceMarketRemoteService;
import com.jason.common.Result.CommonResult;
import org.springframework.cloud.openfeign.FallbackFactory;

/**
 * @author：yangwushuo
 * @time：2022/12/1 9:33
 */
public class BinanceMarketRemoteServiceFallbackFactory implements FallbackFactory<BinanceMarketRemoteService> {
    @Override
    public BinanceMarketRemoteService create(Throwable cause) {
        return new BinanceMarketRemoteService() {

            @Override
            public CommonResult<String> marketPing() {
                return CommonResult.failed("联通失败");
            }
        };
    }
}
