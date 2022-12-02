package com.jason.binance.api.service;

import com.jason.binance.api.fallback.BinanceSpotRemoteServiceFallbackFactory;
import com.jason.common.Result.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 币安市场行情服务
 * @author：yangwushuo
 * @time：2022/12/1 9:32
 */
@FeignClient(name = "qingpu-binance-provider", fallbackFactory = BinanceSpotRemoteServiceFallbackFactory.class)
public interface BinanceMarketRemoteService {

    /**
     * @return a
     * @Author yangwushuo
     * @Decription //TODO 测试能否联通 Rest API
     * @Date 10:13 2022/12/1
     * @Param
     **/
    @GetMapping("/binance/market/ping")
    CommonResult<String> marketPing();



}
