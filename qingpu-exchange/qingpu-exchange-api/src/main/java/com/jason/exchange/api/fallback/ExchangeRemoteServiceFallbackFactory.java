package com.jason.exchange.api.fallback;

import com.jason.common.Result.CommonResult;
import com.jason.exchange.api.request.QuarterRequest;
import com.jason.exchange.api.service.ExchangeRemoteService;
import com.jason.exchange.biz.po.*;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author：yangwushuo
 * @time：2022/11/17 14:15
 */
public class ExchangeRemoteServiceFallbackFactory implements FallbackFactory<ExchangeRemoteService> {
    @Override
    public ExchangeRemoteService create(Throwable cause) {
        return new ExchangeRemoteService() {

            @Override
            public CommonResult<String> delUserCoinExchangeAccount(String userInfo, Long exAccId) {
                return CommonResult.failed("删除失败");
            }

            @Override
            public CommonResult<String> addFinanceFile(String userInfo, Integer id, String title, MultipartFile file) {
                return CommonResult.failed("失败");
            }

            @Override
            public CommonResult<String> addQuarter(String userInfo, QuarterRequest quarterRequest) {
                return CommonResult.failed("失败");
            }

            @Override
            public CommonResult<List<QuarterPo>> getQuarter() {
                return CommonResult.failed("失败");
            }

            @Override
            public CommonResult<List<QuarterPo>> getFinanceFile(String userInfo) {
                return CommonResult.failed("失败");
            }

            @Override
            public CommonResult<String> addFavoriteFile(String userInfo, Integer financialId) {
                return CommonResult.failed("失败");
            }

            @Override
            public CommonResult<List<QuarterPo>> getFavoriteFile(String userInfo) {
                return CommonResult.failed("失败");
            }

            @Override
            public CommonResult<String> delFavoriteFile(String userInfo, Integer id) {
                return CommonResult.failed("失败");
            }

            @Override
            public CommonResult<String> addNews(String userInfo, MultipartFile file, String title, String content) {
                return CommonResult.failed("失败");
            }

            @Override
            public CommonResult<String> delNews(String userInfo, Integer newsId) {
                return CommonResult.failed("失败");
            }

            @Override
            public CommonResult<List<NewsPo>> getNews() {
                return CommonResult.failed("失败");
            }

            @Override
            public CommonResult<List<NewsPo>> getSearchNews(String userInfo, String keywords) {
                return CommonResult.failed("失败");
            }

            @Override
            public CommonResult<String> addNewsLike(String userInfo, Integer newsId) {
                return CommonResult.failed("失败");
            }

            @Override
            public CommonResult<String> delNewsLike(String userInfo, Integer newsId) {
                return CommonResult.failed("失败");
            }

            @Override
            public CommonResult<List<UserInfoPo>> getAllUserInfo() {
                return CommonResult.failed("失败");
            }

            @Override
            public CommonResult<String> upUserDisabled(String userInfo, Long userId) {
                return CommonResult.failed("失败");
            }

            @Override
            public CommonResult<String> upUserEnabled(String userInfo, Long userId) {
                return CommonResult.failed("失败");
            }

            @Override
            public CommonResult<List<UserInfoPo>> searchUser(String username) {
                return CommonResult.failed("失败");
            }

            @Override
            public CommonResult<String> addStock(String symbol, Integer code) {
                return CommonResult.failed("失败");
            }

            @Override
            public CommonResult<List<StockPo>> getStock() {
                return CommonResult.failed("失败");
            }

            @Override
            public CommonResult<String> delStock(Integer id) {
                return CommonResult.failed("失败");
            }

            @Override
            public CommonResult<List<StockHistoryPo>> getStockHistory(String stockId, Integer scale, Long timestamp) {
                return CommonResult.failed("失败");
            }

        };
    }
}
