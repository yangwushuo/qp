package com.jason.binance.provider.service;

import com.jason.binance.api.request.BinanceParamRequest;
import com.jason.binance.api.service.BinanceSpotRemoteService;
import com.jason.binance.biz.service.impl.spot.Trade;
import com.jason.binance.biz.service.impl.spot.Wallet;
import com.jason.binance.biz.utils.RequestHandler;
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
@Api(tags = "binance spot api")
public class BinanceSpotRemoteServiceImpl implements BinanceSpotRemoteService {

    private final RequestMapStruct requestMapStruct;

    private final Wallet wallet;

    private final Trade trade;

    public BinanceSpotRemoteServiceImpl(RequestMapStruct requestMapStruct, Wallet wallet, Trade trade) {
        this.requestMapStruct = requestMapStruct;
        this.wallet = wallet;
        this.trade = trade;
    }

    @Override
    @ApiOperation(value ="测试下单", notes = "ROLE:SERVICE")
    @ApiImplicitParam(paramType = "body", name = "binanceKey", value = "币安密钥对", required = true)
    @ApiResponses({
            @ApiResponse(code = 200, message = "测试成功"),
            @ApiResponse(code = 500, message = "测试失败")
    })
    public CommonResult<String> spotOrderTest(BinanceParamRequest binanceParamRequest) {
        RequestHandler requestHandler = new RequestHandler(binanceParamRequest.getApiKey(), binanceParamRequest.getSecretKey());
        String reqRes = trade.testNewOrder(requestHandler, new LinkedHashMap<>());
        return CommonResult.success("测试成功");
    }

    @Override
    @ApiOperation(value ="币安现货账户信息", notes = "ROLE:SERVICE")
    @ApiImplicitParam(paramType = "body", name = "binanceKey", value = "币安密钥对", required = true)
    @ApiResponses({
            @ApiResponse(code = 200, message = "获取成功"),
            @ApiResponse(code = 500, message = "获取失败")
    })
    public CommonResult<String> spotAccountInfo(BinanceParamRequest binanceParamRequest) {
        RequestHandler requestHandler = new RequestHandler(binanceParamRequest.getApiKey(), binanceParamRequest.getSecretKey());
        String reqRes = trade.account(requestHandler, new LinkedHashMap<>());
        return CommonResult.success(reqRes);
    }

    @Override
    @ApiOperation(value ="币安账户权限", notes = "ROLE:SERVICE")
    @ApiImplicitParam(paramType = "body", name = "binanceKey", value = "币安密钥对", required = true)
    @ApiResponses({
            @ApiResponse(code = 200, message = "获取成功"),
            @ApiResponse(code = 500, message = "获取失败")
    })
    public CommonResult<String> accountPer(BinanceParamRequest binanceParamRequest) {
        RequestHandler requestHandler = new RequestHandler(binanceParamRequest.getApiKey(), binanceParamRequest.getSecretKey());
        String reqRes = wallet.apiPermission(requestHandler, new LinkedHashMap<>());
        return CommonResult.success(reqRes);
    }

    @Override
    @ApiOperation(value ="币安现货所有订单", notes = "ROLE:SERVICE")
    @ApiImplicitParam(paramType = "body", name = "binanceKey", value = "币安密钥对", required = true)
    @ApiResponses({
            @ApiResponse(code = 200, message = "获取成功"),
            @ApiResponse(code = 500, message = "获取失败")
    })
    public CommonResult<String> spotAllOrders(BinanceParamRequest binanceParamRequest) {
        RequestHandler requestHandler = new RequestHandler(binanceParamRequest.getApiKey(), binanceParamRequest.getSecretKey());
        String reqRes = trade.getOrders(requestHandler, binanceParamRequest.getParams());
        return CommonResult.success(reqRes);
    }

    @Override
    @ApiOperation(value ="币安现货所有订单", notes = "ROLE:SERVICE")
    @ApiImplicitParam(paramType = "body", name = "binanceKey", value = "币安密钥对", required = true)
    @ApiResponses({
            @ApiResponse(code = 200, message = "获取成功"),
            @ApiResponse(code = 500, message = "获取失败")
    })
    public CommonResult<String> spotOpenOrders(BinanceParamRequest binanceParamRequest) {
        RequestHandler requestHandler = new RequestHandler(binanceParamRequest.getApiKey(), binanceParamRequest.getSecretKey());
        String reqRes = trade.getOpenOrders(requestHandler, binanceParamRequest.getParams());
        return CommonResult.success(reqRes);
    }

    @Override
    @ApiOperation(value ="币安现货Oco所有订单", notes = "ROLE:SERVICE")
    @ApiImplicitParam(paramType = "body", name = "binanceKey", value = "币安密钥对", required = true)
    @ApiResponses({
            @ApiResponse(code = 200, message = "获取成功"),
            @ApiResponse(code = 500, message = "获取失败")
    })
    public CommonResult<String> spotOcoOrders(BinanceParamRequest binanceParamRequest) {
        RequestHandler requestHandler = new RequestHandler(binanceParamRequest.getApiKey(), binanceParamRequest.getSecretKey());
        String reqRes = trade.getOCOOrders(requestHandler, binanceParamRequest.getParams());
        return CommonResult.success(reqRes);
    }

    @Override
    @ApiOperation(value ="币安现货Oco所有挂单", notes = "ROLE:SERVICE")
    @ApiImplicitParam(paramType = "body", name = "binanceKey", value = "币安密钥对", required = true)
    @ApiResponses({
            @ApiResponse(code = 200, message = "获取成功"),
            @ApiResponse(code = 500, message = "获取失败")
    })
    public CommonResult<String> spotOpenOcoOrders(BinanceParamRequest binanceParamRequest) {
        RequestHandler requestHandler = new RequestHandler(binanceParamRequest.getApiKey(), binanceParamRequest.getSecretKey());
        String reqRes = trade.getOpenOCOOrders(requestHandler, binanceParamRequest.getParams());
        return CommonResult.success(reqRes);
    }

    @Override
    @ApiOperation(value ="币安现货成交历史", notes = "ROLE:SERVICE")
    @ApiImplicitParam(paramType = "body", name = "binanceKey", value = "币安密钥对", required = true)
    @ApiResponses({
            @ApiResponse(code = 200, message = "获取成功"),
            @ApiResponse(code = 500, message = "获取失败")
    })
    public CommonResult<String> spotTrades(BinanceParamRequest binanceParamRequest) {
        RequestHandler requestHandler = new RequestHandler(binanceParamRequest.getApiKey(), binanceParamRequest.getSecretKey());
        String reqRes = trade.myTrades(requestHandler, binanceParamRequest.getParams());
        return CommonResult.success(reqRes);
    }

    @Override
    @ApiOperation(value ="币安现货目前下单数", notes = "ROLE:SERVICE")
    @ApiImplicitParam(paramType = "body", name = "binanceKey", value = "币安密钥对", required = true)
    @ApiResponses({
            @ApiResponse(code = 200, message = "获取成功"),
            @ApiResponse(code = 500, message = "获取失败")
    })
    public CommonResult<String> spotRateLimitOrder(BinanceParamRequest binanceParamRequest) {
        RequestHandler requestHandler = new RequestHandler(binanceParamRequest.getApiKey(), binanceParamRequest.getSecretKey());
        String reqRes = trade.rateLimitOrder(requestHandler, binanceParamRequest.getParams());
        return CommonResult.success(reqRes);
    }


}
