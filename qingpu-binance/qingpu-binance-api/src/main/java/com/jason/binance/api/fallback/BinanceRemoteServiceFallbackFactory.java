package com.jason.binance.api.fallback;

import com.jason.binance.api.request.BinanceKeyRequest;
import com.jason.binance.api.service.BinanceRemoteService;
import com.jason.common.Result.CommonResult;
import org.springframework.cloud.openfeign.FallbackFactory;

/**
 * @author：yangwushuo
 * @time：2022/11/23 16:00
 */
public class BinanceRemoteServiceFallbackFactory implements FallbackFactory<BinanceRemoteService> {
    @Override
    public BinanceRemoteService create(Throwable cause) {
        return new BinanceRemoteService() {

            @Override
            public CommonResult<String> orderTest(BinanceKeyRequest binanceKey) {
                return CommonResult.failed("测试订单失败");
            }

            @Override
            public CommonResult<String> accountInfo(BinanceKeyRequest binanceKey) {
                return CommonResult.failed("获取交易账户信息失败");
            }
        };
    }
}
