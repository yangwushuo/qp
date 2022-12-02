package com.jason.exchange.api.service;

import com.jason.common.Result.CommonResult;
import com.jason.exchange.api.fallback.ExchangeRemoteServiceFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author：yangwushuo
 * @time：2022/12/1 10:27
 */
@FeignClient(name = "qingpu-exchange-provider", fallbackFactory = ExchangeRemoteServiceFallbackFactory.class)
public interface BinanceExchangeRemoteService {

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


    /**
     * @return a
     * @Author yangwushuo
     * @Decription //TODO 获取币安交易账户成交历史
     * @Date 8:16 2022/12/1
     * @Param
     **/
    @GetMapping("/ex/user/binance/spot/myTrades")
    CommonResult<Object> getUserBinanceSpotTrades(
            @RequestHeader("user") String userInfo,
            @RequestParam("exAccId") Long exAccId,
            @RequestParam("symbol") String symbol,
            @RequestParam(value = "orderId", required = false) Long orderId,
            @RequestParam(value = "startTime", required = false) Long startTime,
            @RequestParam(value = "endTime" , required = false) Long endTime,
            @RequestParam(value = "fromId", required = false) Long fromId,
            @RequestParam(value = "limit", required = false) Integer limit
    );

    /**
     * @return a
     * @Author yangwushuo
     * @Decription //TODO 获取币安交易账户目前下单数
     * @Date 8:47 2022/12/1
     * @Param
     **/
    @GetMapping("/ex/user/binance/spot/rateLimit/order")
    CommonResult<Object> getUserBinanceSpotRateLimitOrder(
            @RequestHeader("user") String userInfo,
            @RequestParam("exAccId") Long exAccId
    );

    /**
     * @return a
     * @Author yangwushuo
     * @Descrition //TODO 币安市场行情ping
     * @Date 10:49 2022/12/1
    * @Param
     **/
    @GetMapping("/ex/binance/market/ping")
    CommonResult<Object> getBinanceMarketPing();


}
