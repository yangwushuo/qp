package com.jason.binance.api.service;

import com.jason.binance.api.fallback.BinanceRemoteServiceFallbackFactory;
import com.jason.binance.api.request.BinanceParamRequest;
import com.jason.common.Result.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author：yangwushuo
 * @time：2022/11/23 15:50
 */
@FeignClient(name = "qingpu-binance-provider", fallbackFactory = BinanceRemoteServiceFallbackFactory.class)
public interface BinanceRemoteService {

    /**
     * @return a
     * @Author yangwushuo
     * @Decription //TODO 测试现货下单
     * @Date 10:05 2022/11/28
     * @Param
     **/
    @PostMapping("/binance/order/test")
    CommonResult<String> spotOrderTest(@RequestBody BinanceParamRequest binanceParamRequest);

    /**
     * @return a
     * @Author yangwushuo
     * @Decription //TODO 获取现货账户信息
     * @Date 10:05 2022/11/28
     * @Param
     **/
    @PostMapping("/binance/account/info")
    CommonResult<String> spotAccountInfo(@RequestBody BinanceParamRequest binanceParamRequest);

    /**
     * @return a
     * @Author yangwushuo
     * @Decription //TODO 获取账户权限
     * @Date 11:26 2022/11/28
     * @Param
     **/
    @PostMapping("/binance/account/per")
    CommonResult<String> accountPer(@RequestBody BinanceParamRequest binanceParamRequest);


    /**
     * @return a
     * @Author yangwushuo
     * @Decription //TODO 获取现货所有订单
     * @Date 13:52 2022/11/28
     * @Param
     **/
    @PostMapping("/binance/spot/allOrders")
    CommonResult<String> spotAllOrders(@RequestBody BinanceParamRequest binanceParamRequest);

    /**
     * @return a
     * @Author yangwushuo
     * @Decription //TODO 获取现货所有挂单
     * @Date 16:14 2022/11/29
     * @Param
     **/
    @PostMapping("/binance/spot/openOrders")
    CommonResult<String> spotOpenOrders(@RequestBody BinanceParamRequest binanceParamRequest);

    /**
     * @Author yangwushuo
     * @Description //TODO 获取现货所有oco订单
     * @Date 20:08 2022/11/29
     * @Param
     * @return
     **/
    @PostMapping("/binance/spot/ocoOrders")
    CommonResult<String> spotOcoOrders(@RequestBody BinanceParamRequest binanceParamRequest);

    /**
     * @return a
     * @Author yangwushuo
     * @Decription //TODO 获取现货所有oco挂单
     * @Date 20:14 2022/11/29
     * @Param
     **/
    @PostMapping("/binance/spot/ocoOpenOrders")
    CommonResult<String> spotOpenOcoOrders(@RequestBody BinanceParamRequest binanceParamRequest);

}
