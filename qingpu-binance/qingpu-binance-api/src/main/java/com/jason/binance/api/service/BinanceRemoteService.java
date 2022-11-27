package com.jason.binance.api.service;

import com.jason.binance.api.fallback.BinanceRemoteServiceFallbackFactory;
import com.jason.binance.api.request.BinanceKeyRequest;
import com.jason.common.Result.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author：yangwushuo
 * @time：2022/11/23 15:50
 */
@FeignClient(name = "qingpu-binance-provider", fallbackFactory = BinanceRemoteServiceFallbackFactory.class)
public interface BinanceRemoteService {

    @PostMapping("/binance/order/test")
    CommonResult<String> orderTest(@RequestBody BinanceKeyRequest binanceKey);

    @PostMapping("/binance/account/info")
    CommonResult<String> accountInfo(@RequestBody BinanceKeyRequest binanceKey);


}
