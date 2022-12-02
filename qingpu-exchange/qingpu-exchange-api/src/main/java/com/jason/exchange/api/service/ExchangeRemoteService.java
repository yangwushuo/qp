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

}
