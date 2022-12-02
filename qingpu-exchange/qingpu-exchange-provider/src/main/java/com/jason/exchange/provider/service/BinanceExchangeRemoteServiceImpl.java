package com.jason.exchange.provider.service;

import com.jason.binance.api.service.BinanceSpotRemoteService;
import com.jason.common.Result.CommonResult;
import com.jason.common.entity.HeaderUserInfo;
import com.jason.common.util.JsonToObject;
import com.jason.exchange.api.service.BinanceExchangeRemoteService;
import com.jason.exchange.biz.service.BinanceExchangeService;
import com.jason.exchange.provider.mapstruct.RequestMapStruct;
import com.jason.exchange.provider.mapstruct.ResponseMapStruct;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author：yangwushuo
 * @time：2022/12/1 10:39
 */
@RestController
@Api(tags = "币安交易所服务接口")
public class BinanceExchangeRemoteServiceImpl implements BinanceExchangeRemoteService {

    private final ResponseMapStruct responseMapStruct;

    private final RequestMapStruct requestMapStruct;

    private final BinanceSpotRemoteService binanceRemoteService;

    private final BinanceExchangeService exchangeService;

    public BinanceExchangeRemoteServiceImpl(ResponseMapStruct responseMapStruct, RequestMapStruct requestMapStruct, BinanceSpotRemoteService binanceRemoteService, BinanceExchangeService exchangeService) {
        this.responseMapStruct = responseMapStruct;
        this.requestMapStruct = requestMapStruct;
        this.binanceRemoteService = binanceRemoteService;
        this.exchangeService = exchangeService;
    }

    @Override
    @ApiOperation(value ="获取用户币安现货账号信息", notes = "ROLE:ADMIN,USER,BOSS")
    @ApiImplicitParam(paramType = "query", name = "exAccId", value = "交易账号id", required = true)
    @ApiResponses({
            @ApiResponse(code = 200, message = "获取成功"),
            @ApiResponse(code = 500, message = "获取失败")
    })
    public CommonResult<Object> getUserBinanceSpotAccountInfo(String userInfo, Long exAccId) {
        HeaderUserInfo headerUserInfo = JsonToObject.jsonToClass(userInfo, HeaderUserInfo.class);
        return CommonResult.success(exchangeService.getBinanceSpotAccountInfo(headerUserInfo.getId(), exAccId));
    }

    @Override
    @ApiOperation(value ="获取用户币安现货账号信息", notes = "ROLE:ADMIN,USER,BOSS")
    @ApiImplicitParam(paramType = "query", name = "exAccId", value = "交易账号id", required = true)
    @ApiResponses({
            @ApiResponse(code = 200, message = "获取成功"),
            @ApiResponse(code = 500, message = "获取失败")
    })
    public CommonResult<Object> getUserBinanceSpotOrders(String userInfo, Long exAccId, String symbol, Long orderId, Long startTime, Long endTime, Integer limit) {
        HeaderUserInfo headerUserInfo = JsonToObject.jsonToClass(userInfo, HeaderUserInfo.class);
        return CommonResult.success(exchangeService.getBinanceSpotOrders(headerUserInfo.getId(), exAccId, symbol, orderId, startTime, endTime, limit));
    }

    @Override
    @ApiOperation(value ="获取用户币安现货挂单", notes = "ROLE:ADMIN,USER,BOSS")
    @ApiImplicitParam(paramType = "query", name = "exAccId", value = "交易账号id", required = true)
    @ApiResponses({
            @ApiResponse(code = 200, message = "获取成功"),
            @ApiResponse(code = 500, message = "获取失败")
    })
    public CommonResult<Object> getUserBinanceSpotOpenOrders(String userInfo, Long exAccId, String symbol) {
        HeaderUserInfo headerUserInfo = JsonToObject.jsonToClass(userInfo, HeaderUserInfo.class);
        return CommonResult.success(exchangeService.getBinanceSpotOpenOrders(headerUserInfo.getId(), exAccId, symbol));
    }

    @Override
    @ApiOperation(value ="获取用户币安现货所有OCO订单", notes = "ROLE:ADMIN,USER,BOSS")
    @ApiImplicitParam(paramType = "query", name = "exAccId", value = "交易账号id", required = true)
    @ApiResponses({
            @ApiResponse(code = 200, message = "获取成功"),
            @ApiResponse(code = 500, message = "获取失败")
    })
    public CommonResult<Object> getUserBinanceSpotOcoOrders(String userInfo, Long exAccId, Long fromId, Long startTime, Long endTime, Integer limit) {
        HeaderUserInfo headerUserInfo = JsonToObject.jsonToClass(userInfo, HeaderUserInfo.class);
        return CommonResult.success(exchangeService.getBinanceSpotOcoOrders(headerUserInfo.getId(), exAccId, fromId, startTime, endTime, limit));
    }

    @Override
    @ApiOperation(value ="获取用户币安现货所有OCO挂单", notes = "ROLE:ADMIN,USER,BOSS")
    @ApiImplicitParam(paramType = "query", name = "exAccId", value = "交易账号id", required = true)
    @ApiResponses({
            @ApiResponse(code = 200, message = "获取成功"),
            @ApiResponse(code = 500, message = "获取失败")
    })
    public CommonResult<Object> getUserBinanceSpotOpenOcoOrders(String userInfo, Long exAccId) {
        HeaderUserInfo headerUserInfo = JsonToObject.jsonToClass(userInfo, HeaderUserInfo.class);
        return CommonResult.success(exchangeService.getBinanceSpotOpenOcoOrders(headerUserInfo.getId(), exAccId));
    }

    @Override
    @ApiOperation(value ="获取用户币安现货成交历史", notes = "ROLE:ADMIN,USER,BOSS")
    @ApiImplicitParam(paramType = "query", name = "exAccId", value = "交易账号id", required = true)
    @ApiResponses({
            @ApiResponse(code = 200, message = "获取成功"),
            @ApiResponse(code = 500, message = "获取失败")
    })
    public CommonResult<Object> getUserBinanceSpotTrades(String userInfo, Long exAccId, String symbol, Long orderId, Long startTime, Long endTime, Long fromId, Integer limit) {
        HeaderUserInfo headerUserInfo = JsonToObject.jsonToClass(userInfo, HeaderUserInfo.class);
        return CommonResult.success(exchangeService.getBinanceSpotTrades(headerUserInfo.getId(), exAccId, symbol, orderId, startTime, endTime, fromId, limit));
    }

    @Override
    @ApiOperation(value ="获取用户币安现货当前下单数", notes = "ROLE:ADMIN,USER,BOSS")
    @ApiImplicitParam(paramType = "query", name = "exAccId", value = "交易账号id", required = true)
    @ApiResponses({
            @ApiResponse(code = 200, message = "获取成功"),
            @ApiResponse(code = 500, message = "获取失败")
    })
    public CommonResult<Object> getUserBinanceSpotRateLimitOrder(String userInfo, Long exAccId) {
        HeaderUserInfo headerUserInfo = JsonToObject.jsonToClass(userInfo, HeaderUserInfo.class);
        return CommonResult.success(exchangeService.getBinanceSpotRateLimitOrder(headerUserInfo.getId(), exAccId));
    }

    @Override
    @ApiOperation(value ="币安市场行情联通", notes = "ROLE:ADMIN,USER,BOSS")
    @ApiResponses({
            @ApiResponse(code = 200, message = "获取成功"),
            @ApiResponse(code = 500, message = "获取失败")
    })
    public CommonResult<Object> getBinanceMarketPing() {
        return CommonResult.success(exchangeService.binanceMarketPing());
    }

}
