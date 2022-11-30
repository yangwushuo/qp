package com.jason.binance.api.fallback;

import com.jason.binance.api.request.BinanceParamRequest;
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
            public CommonResult<String> spotOrderTest(BinanceParamRequest binanceKey) {
                return CommonResult.failed("测试订单失败");
            }

            @Override
            public CommonResult<String> spotAccountInfo(BinanceParamRequest binanceKey) {
                return CommonResult.failed("获取交易账户信息失败");
            }

            @Override
            public CommonResult<String> accountPer(BinanceParamRequest binanceParamRequest) {
                return CommonResult.failed("获取权限信息失败");
            }

            @Override
            public CommonResult<String> spotAllOrders(BinanceParamRequest binanceKey) {
                return CommonResult.failed("获取订单列表失败");
            }

            @Override
            public CommonResult<String> spotOpenOrders(BinanceParamRequest binanceParamRequest) {
                return CommonResult.failed("获取改单列表失败");
            }

            @Override
            public CommonResult<String> spotOcoOrders(BinanceParamRequest binanceParamRequest) {
                return CommonResult.failed("获取Oco订单失败");
            }

            @Override
            public CommonResult<String> spotOpenOcoOrders(BinanceParamRequest binanceParamRequest) {
                return CommonResult.failed("获取Oco挂单失败");
            }
        };
    }
}
