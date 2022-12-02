package com.jason.binance.provider.service;

import com.jason.binance.api.service.BinanceMarketRemoteService;
import com.jason.binance.biz.service.impl.spot.Market;
import com.jason.binance.biz.utils.RequestHandler;
import com.jason.common.Result.CommonResult;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author：yangwushuo
 * @time：2022/12/1 10:16
 */
@RestController
@Api(tags = "binance market api")
public class BinanceMarketRemoteServiceImpl implements BinanceMarketRemoteService {

    private final Market market;

    public BinanceMarketRemoteServiceImpl(Market market) {
        this.market = market;
    }

    @Override
    public CommonResult<String> marketPing() {
        return CommonResult.success(market.ping(new RequestHandler()));
    }

}
