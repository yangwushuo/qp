package com.jason.exchange.api.service;

import com.jason.common.Result.CommonResult;
import com.jason.exchange.api.fallback.ExchangeRemoteServiceFallbackFactory;
import com.jason.exchange.api.request.QuarterRequest;
import com.jason.exchange.biz.po.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author：yangwushuo
 * @time：2022/11/17 14:14
 */
@FeignClient(name = "qingpu-exchange-provider", fallbackFactory = ExchangeRemoteServiceFallbackFactory.class)
public interface ExchangeRemoteService {

//    /**
//     * @return
//     * @Author yangwushuo
//     * @Decription //TODO 获取所有支持的数字货币交易所
//     * @Date 19:18 2022/11/7
//     * @Param
//     **/
//    @GetMapping("/ex/coinExs")
//    CommonResult<List<CoinExchangeResponse>> allCoinExchange();
//
//    /**
//     * @return a
//     * @Author yangwushuo
//     * @Decription //TODO 获取用户交易账号信息
//     * @Date 16:17 2022/11/18
//     * @Param
//     **/
//    @GetMapping("/ex/user/acc/coin")
//    CommonResult<List<CoinExchangeAccountResponse>> getUserCoinExchangeAccount(
//            @RequestParam("userId") Long userId,
//            @RequestParam(value = "exId", required = false) Long exId
//    );
//
//    /**
//     * @return a
//     * @Author yangwushuo
//     * @Decription //TODO 添加用户交易账户信息
//     * @Date 14:29 2022/11/22
//     * @Param
//     **/
//    @PostMapping("/ex/user/acc/coin/add")
//    CommonResult<String> addUserCoinExchangeAccount(
//            @RequestHeader("user")String userInfo,
//            @RequestBody AddCoinExchangeAccountRequest addCoinExchangeAccountRequest
//    );
//
//    /**
//     * @return a
//     * @Author yangwushuo
//     * @Decription //TODO 更新用户交易账户信息
//     * @Date 14:13 2022/11/21
//     * @Param
//     **/
//    @PutMapping("/ex/user/acc/coin/up")
//    CommonResult<String> upUserCoinExchangeAccount(
//            @RequestHeader("user")String userInfo,
//            @RequestBody UpCoinExchangeAccountRequest upCoinExchangeAccountRequest
//    );

    /**
     * @return a
     * @Author yangwushuo
     * @Decription //TODO 删除用户交易账号
     * @Date 14:13 2022/11/21
     * @Param
     **/
    @DeleteMapping("/ex/user/acc/coin/del")
    CommonResult<String> delUserCoinExchangeAccount(
            @RequestHeader("user") String userInfo,
            @RequestParam("exAccId") Long exAccId
    );

    /**
     * @return a
     * @Author yangwushuo
     * @Decription //TODO 添加财报
     * @Date 14:13 2022/11/21
     * @Param
     **/
    @PostMapping("/ex/add_finance_file")
    CommonResult<String> addFinanceFile(
            @RequestHeader("user") String userInfo,
            @RequestParam("quarterId") Integer id,
            @RequestParam("title") String title,
            @RequestParam("file") MultipartFile file
    );

    @PostMapping("/ex/add_quarter")
    CommonResult<String> addQuarter(@RequestHeader("user") String userInfo,@RequestBody QuarterRequest quarterRequest);

    @GetMapping("/ex/get_quarter")
    CommonResult<List<QuarterPo>> getQuarter();

    @GetMapping("/ex/get_finance_file")
    CommonResult<List<QuarterPo>> getFinanceFile(@RequestHeader("user") String userInfo);

    @PostMapping("/ex/favorite_files")
    CommonResult<String> addFavoriteFile(@RequestHeader("user") String userInfo, @RequestParam("financialId")Integer financialId);

    @GetMapping("/ex/favorite_files")
    CommonResult<List<QuarterPo>> getFavoriteFile(@RequestHeader("user") String userInfo);

    @DeleteMapping("/ex/favorite_files")
    CommonResult<String> delFavoriteFile(@RequestHeader("user") String userInfo, @RequestParam("id")Integer id);

    @PostMapping("/ex/news")
    CommonResult<String> addNews(@RequestHeader("user") String userInfo,@RequestParam("file") MultipartFile file, @RequestParam("title")String title, @RequestParam("content")String content);

    @DeleteMapping("/ex/news")
    CommonResult<String> delNews(@RequestHeader("user") String userInfo, @RequestParam("newsId") Integer newsId);

    @GetMapping("/ex/news")
    CommonResult<List<NewsPo>> getNews();

    @GetMapping("/ex/search_news")
    CommonResult<List<NewsPo>> getSearchNews(@RequestHeader("user") String userInfo, @RequestParam("keywords") String keywords);

    @PostMapping("/ex/news_like")
    CommonResult<String> addNewsLike(@RequestHeader("user") String userInfo, @RequestParam("newsId")Integer newsId);

    @DeleteMapping("/ex/news_like")
    CommonResult<String> delNewsLike(@RequestHeader("user") String userInfo, @RequestParam("newsId")Integer newsId);

    @GetMapping("/ex/user_management")
    CommonResult<List<UserInfoPo>> getAllUserInfo();

    @PutMapping("/ex/user_disabled")
    CommonResult<String> upUserDisabled(@RequestHeader("user") String userInfo, @RequestParam("userId")Long userId);

    @PutMapping("/ex/user_enabled")
    CommonResult<String> upUserEnabled(@RequestHeader("user") String userInfo, @RequestParam("userId")Long userId);

    @GetMapping("/ex/search_user")
    CommonResult<List<UserInfoPo>> searchUser(@RequestParam("username")String username);

    @PostMapping("/ex/stock")
    CommonResult<String> addStock(@RequestParam("symbol")String symbol, @RequestParam(value = "code",required = false) Integer code);

    @GetMapping("/ex/stock")
    CommonResult<List<StockPo>> getStock();

    @DeleteMapping("/ex/stock")
    CommonResult<String> delStock(@RequestParam("id")Integer id);

    @GetMapping("/ex/stock_history")
    CommonResult<List<StockHistoryPo>> getStockHistory(@RequestParam("stockId")String stockId, @RequestParam("scale")Integer scale, @RequestParam("timestamp")Long timestamp);

    //
//    @DeleteMapping("ex/del_finance_file")
//    CommonResult<String> delFinanceFile(@RequestHeader("user") String userInf,@RequestParam("id") Long id);

}
