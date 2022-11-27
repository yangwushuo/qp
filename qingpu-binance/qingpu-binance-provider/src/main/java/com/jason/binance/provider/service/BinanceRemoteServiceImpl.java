package com.jason.binance.provider.service;

import com.jason.binance.api.request.BinanceKeyRequest;
import com.jason.binance.api.service.BinanceRemoteService;
import com.jason.binance.biz.service.BinanceSpotService;
import com.jason.binance.biz.service.impl.BinanceSpotServiceImpl;
import com.jason.binance.biz.service.impl.spot.Trade;
import com.jason.binance.provider.mapstruct.RequestMapStruct;
import com.jason.common.Result.CommonResult;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;

/**
 * @author：yangwushuo
 * @time：2022/11/23 16:18
 */
@RestController
@Api(tags = "binance api")
public class BinanceRemoteServiceImpl implements BinanceRemoteService {

    private final BinanceSpotService binanceSpotService;

    private final RequestMapStruct requestMapStruct;

    public BinanceRemoteServiceImpl(BinanceSpotService binanceSpotService, RequestMapStruct requestMapStruct) {
        this.binanceSpotService = binanceSpotService;
        this.requestMapStruct = requestMapStruct;
    }

    @Override
    @ApiOperation(value ="测试下单", notes = "ROLE:SERVICE")
    @ApiImplicitParam(paramType = "body", name = "binanceKey", value = "币安密钥对", required = true)
    @ApiResponses({
            @ApiResponse(code = 200, message = "测试成功"),
            @ApiResponse(code = 500, message = "测试失败")
    })
    public CommonResult<String> orderTest(BinanceKeyRequest binanceKey) {
        return CommonResult.success("测试成功");
    }

    @Override
    @ApiOperation(value ="币安现货账户信息", notes = "ROLE:SERVICE")
    @ApiImplicitParam(paramType = "body", name = "binanceKey", value = "币安密钥对", required = true)
    @ApiResponses({
            @ApiResponse(code = 200, message = "获取成功"),
            @ApiResponse(code = 500, message = "获取失败")
    })
    public CommonResult<String> accountInfo(BinanceKeyRequest binanceKey) {
        System.out.println("正在获取:"+binanceKey.toString());
        Trade trade = new BinanceSpotServiceImpl(binanceKey.getApiKey(), binanceKey.getSecretKey()).createTrade();
        return CommonResult.success(trade.account(new LinkedHashMap<>()));
    }

}
