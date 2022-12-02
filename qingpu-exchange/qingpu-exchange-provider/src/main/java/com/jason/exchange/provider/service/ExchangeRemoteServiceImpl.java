package com.jason.exchange.provider.service;

import com.jason.binance.api.service.BinanceSpotRemoteService;
import com.jason.common.Result.CommonResult;
import com.jason.common.entity.HeaderUserInfo;
import com.jason.common.util.JsonToObject;
import com.jason.exchange.api.request.AddCoinExchangeAccountRequest;
import com.jason.exchange.api.request.UpCoinExchangeAccountRequest;
import com.jason.exchange.api.response.CoinExchangeAccountResponse;
import com.jason.exchange.api.response.CoinExchangeResponse;
import com.jason.exchange.api.service.ExchangeRemoteService;
import com.jason.exchange.biz.bo.CoinExchangeAccountBo;
import com.jason.exchange.biz.service.ExchangeService;
import com.jason.exchange.provider.mapstruct.RequestMapStruct;
import com.jason.exchange.provider.mapstruct.ResponseMapStruct;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author：yangwushuo
 * @time：2022/11/17 15:14
 */
@RestController
@Api(tags = "交易所服务接口")
public class ExchangeRemoteServiceImpl implements ExchangeRemoteService {

    private final ExchangeService exchangeService;

    private final ResponseMapStruct responseMapStruct;

    private final RequestMapStruct requestMapStruct;

    private final BinanceSpotRemoteService binanceRemoteService;

    public ExchangeRemoteServiceImpl(ExchangeService exchangeService, ResponseMapStruct responseMapStruct, RequestMapStruct requestMapStruct, BinanceSpotRemoteService binanceRemoteService) {
        this.exchangeService = exchangeService;
        this.responseMapStruct = responseMapStruct;
        this.requestMapStruct = requestMapStruct;
        this.binanceRemoteService = binanceRemoteService;
    }

    @Override
    @ApiOperation(value ="获取所有支持的数字货币交易所", notes = "ROLE:ADMIN,USER,BOSS")
    @ApiResponses({
            @ApiResponse(code = 200, message = "获取成功"),
            @ApiResponse(code = 500, message = "获取失败")
    })
    public CommonResult<List<CoinExchangeResponse>> allCoinExchange() {
        return CommonResult.success(responseMapStruct.exchangeBoList2ResponseList(exchangeService.getAllCoinExchange()));
    }

    @Override
    @ApiOperation(value ="获取用户的交易所账号信息", notes = "ROLE:SERVICE")
    @ApiImplicitParam(paramType = "query", name = "exId", value = "交易所id", required = true)
    @ApiResponses({
            @ApiResponse(code = 200, message = "获取成功"),
            @ApiResponse(code = 500, message = "获取失败")
    })
    public CommonResult<List<CoinExchangeAccountResponse>> getUserCoinExchangeAccount(Long userId, Long exId) {
        List<CoinExchangeAccountBo> coinExchangeAccountBos = exchangeService.getCoinExchangeAccount(userId, exId);
        List<CoinExchangeAccountResponse> coinExchangeAccountResponses = responseMapStruct.coinExchangeAccountBoList2ResponseList(coinExchangeAccountBos);
        return CommonResult.success(coinExchangeAccountResponses);
    }

    @Override
    @ApiOperation(value ="添加用户的交易账号信息", notes = "ROLE:ADMIN,USER,BOSS")
    @ApiImplicitParam(paramType = "body", name = "addCoinExchangeAccountRequest", value = "添加请求体", required = true)
    @ApiResponses({
            @ApiResponse(code = 200, message = "添加成功"),
            @ApiResponse(code = 500, message = "添加失败")
    })
    public CommonResult<String> addUserCoinExchangeAccount(String userInfo, AddCoinExchangeAccountRequest addCoinExchangeAccountRequest) {
        HeaderUserInfo headerUserInfo = JsonToObject.jsonToClass(userInfo, HeaderUserInfo.class);
        exchangeService.addCoinExchangeAccount(headerUserInfo.getId(), requestMapStruct.addCoinExchangeAccountRequest2Bo(addCoinExchangeAccountRequest));
        return CommonResult.success("添加成功");
    }

    @Override
    @ApiOperation(value ="更新用户的交易账号信息", notes = "ROLE:ADMIN,USER,BOSS")
    @ApiImplicitParam(paramType = "body", name = "upCoinExchangeAccountRequest", value = "更新请求体", required = true)
    @ApiResponses({
            @ApiResponse(code = 200, message = "更新成功"),
            @ApiResponse(code = 500, message = "更新失败")
    })
    public CommonResult<String> upUserCoinExchangeAccount(String userInfo, UpCoinExchangeAccountRequest upCoinExchangeAccountRequest) {
        HeaderUserInfo headerUserInfo = JsonToObject.jsonToClass(userInfo, HeaderUserInfo.class);
        exchangeService.upCoinExchangeAccount(headerUserInfo.getId(), requestMapStruct.upCoinExchangeAccountRequest2Bo(upCoinExchangeAccountRequest));
        return CommonResult.success("更新成功");
    }

    @Override
    @ApiOperation(value ="删除用户的交易账号信息", notes = "ROLE:ADMIN,USER,BOSS")
    @ApiImplicitParam(paramType = "query", name = "exAccId", value = "交易账号id", required = true)
    @ApiResponses({
            @ApiResponse(code = 200, message = "删除成功"),
            @ApiResponse(code = 500, message = "删除失败")
    })
    public CommonResult<String> delUserCoinExchangeAccount(String userInfo, Long exAccId) {
        HeaderUserInfo headerUserInfo = JsonToObject.jsonToClass(userInfo, HeaderUserInfo.class);
        exchangeService.delCoinExchangeAccount(headerUserInfo.getId(), exAccId);
        return CommonResult.success("删除成功");
    }

}
