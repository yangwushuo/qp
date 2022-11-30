package com.jason.exchange.api.service;

import com.jason.common.Result.CommonResult;
import com.jason.exchange.api.fallback.ExchangeRemoteServiceFallbackFactory;
import com.jason.exchange.api.request.AddCoinExchangeAccountRequest;
import com.jason.exchange.api.request.UpCoinExchangeAccountRequest;
import com.jason.exchange.api.response.CoinExchangeAccountResponse;
import com.jason.exchange.api.response.CoinExchangeResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author：yangwushuo
 * @time：2022/11/17 14:14
 */
@FeignClient(name = "qingpu-exchange-provider", fallbackFactory = ExchangeRemoteServiceFallbackFactory.class)
public interface ExchangeRemoteService {

    /**
     * @return
     * @Author yangwushuo
     * @Decription //TODO 获取所有支持的数字货币交易所
     * @Date 19:18 2022/11/7
     * @Param
     **/
    @GetMapping("/ex/coinExs")
    CommonResult<List<CoinExchangeResponse>> allCoinExchange();

    /**
     * @return a
     * @Author yangwushuo
     * @Decription //TODO 获取用户交易账号信息
     * @Date 16:17 2022/11/18
     * @Param
     **/
    @GetMapping("/ex/user/acc/coin")
    CommonResult<List<CoinExchangeAccountResponse>> getUserCoinExchangeAccount(
            @RequestParam("userId") Long userId,
            @RequestParam(value = "exId", required = false) Long exId
    );

    /**
     * @return a
     * @Author yangwushuo
     * @Decription //TODO 添加用户交易账户信息
     * @Date 14:29 2022/11/22
     * @Param
     **/
    @PostMapping("/ex/user/acc/coin/add")
    CommonResult<String> addUserCoinExchangeAccount(
            @RequestHeader("user")String userInfo,
            @RequestBody AddCoinExchangeAccountRequest addCoinExchangeAccountRequest
    );

    /**
     * @return a
     * @Author yangwushuo
     * @Decription //TODO 更新用户交易账户信息
     * @Date 14:13 2022/11/21
     * @Param
     **/
    @PutMapping("/ex/user/acc/coin/up")
    CommonResult<String> upUserCoinExchangeAccount(
            @RequestHeader("user")String userInfo,
            @RequestBody UpCoinExchangeAccountRequest upCoinExchangeAccountRequest
    );

    /**
     * @return a
     * @Author yangwushuo
     * @Decription //TODO 删除用户交易账号
     * @Date 14:13 2022/11/21
     * @Param
     **/
    @DeleteMapping("/ex/user/acc/coin/del")
    CommonResult<String> delUserCoinExchangeAccount(
            @RequestHeader("user")String userInfo,
            @RequestParam("exAccId") Long exAccId
    );

    /**
     * @return a
     * @Author yangwushuo
     * @Descrition //TODO 获取币安交易账户的现货资产信息
     * @Date 22:04 2022/11/26
    * @Param
     **/
    @GetMapping("/ex/user/binance/acc/info")
    CommonResult<Object> getUserBinanceSpotAccountInfo(
            @RequestHeader("user")String userInfo,
            @RequestParam("exAccId") Long exAccId
    );

    /**
     * @return a
     * @Author yangwushuo
     * @Decription //TODO 获取币安交易账户的订单
     * @Date 14:40 2022/11/28
     * @Param
     **/
    @GetMapping("/ex/user/binance/spot/orders")
    CommonResult<Object> getUserBinanceSpotOrders(
            @RequestHeader("user")String userInfo,
            @RequestParam("exAccId") Long exAccId,
            @RequestParam("symbol") String symbol,
            @RequestParam(value = "orderId",required = false) Long orderId,
            @RequestParam(value = "startTime",required = false) Long startTime,
            @RequestParam(value = "endTime",required = false) Long endTime,
            @RequestParam(value = "limit",required = false) Integer limit
    );

    /**
     * @return a
     * @Author yangwushuo
     * @Decription //TODO 获取币安交易账户的挂单
     * @Date 19:20 2022/11/29
     * @Param
     **/
    @GetMapping("/ex/user/binance/spot/openOrders")
    CommonResult<Object> getUserBinanceSpotOpenOrders(
            @RequestHeader("user") String userInfo,
            @RequestParam("exAccId") Long exAccId,
            @RequestParam(value = "symbol",required = false) String symbol
    );

    /**
     * @return a
     * @Author yangwushuo
     * @Decription //TODO 获取币安交易账户所有Oco订单
     * @Date 19:55 2022/11/29
     * @Param
     **/
    @GetMapping("/ex/user/binance/spot/ocoOrders")
    CommonResult<Object> getUserBinanceSpotOcoOrders(
            @RequestHeader("user") String userInfo,
            @RequestParam("exAccId") Long exAccId,
            @RequestParam(value = "fromId",required = false) Long fromId,
            @RequestParam(value = "startTime",required = false) Long startTime,
            @RequestParam(value = "endTime", required = false) Long endTime,
            @RequestParam(value = "limit", required = false) Integer limit
    );

    /**
     * @return a
     * @Author yangwushuo
     * @Decription //TODO 获取币安交易账号所有oco挂单
     * @Date 20:20 2022/11/29
     * @Param
     **/
    @GetMapping("/ex/user/binance/spot/openOcoOrders")
    CommonResult<Object> getUserBinanceSpotOpenOcoOrders(
            @RequestHeader("user") String userInfo,
            @RequestParam("exAccId") Long exAccId
    );



}
