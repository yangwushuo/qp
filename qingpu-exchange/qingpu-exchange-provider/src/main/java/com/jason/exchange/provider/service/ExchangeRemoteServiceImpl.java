package com.jason.exchange.provider.service;

import com.jason.common.Result.CommonResult;
import com.jason.common.entity.HeaderUserInfo;
import com.jason.common.util.JsonToObject;
import com.jason.exchange.api.request.QuarterRequest;
import com.jason.exchange.api.service.ExchangeRemoteService;
import com.jason.exchange.biz.po.*;
import com.jason.exchange.biz.service.ExchangeService;
import com.jason.exchange.provider.mapstruct.RequestMapStruct;
import com.jason.exchange.provider.mapstruct.ResponseMapStruct;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

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

    public ExchangeRemoteServiceImpl(ExchangeService exchangeService, ResponseMapStruct responseMapStruct, RequestMapStruct requestMapStruct) {
        this.exchangeService = exchangeService;
        this.responseMapStruct = responseMapStruct;
        this.requestMapStruct = requestMapStruct;
    }

//    @Override
//    @ApiOperation(value ="获取所有支持的数字货币交易所", notes = "ROLE:ADMIN,USER,BOSS")
//    @ApiResponses({
//            @ApiResponse(code = 200, message = "获取成功"),
//            @ApiResponse(code = 500, message = "获取失败")
//    })
//    public CommonResult<List<CoinExchangeResponse>> allCoinExchange() {
//        return CommonResult.success(responseMapStruct.exchangeBoList2ResponseList(exchangeService.getAllCoinExchange()));
//    }
//
//    @Override
//    @ApiOperation(value ="获取用户的交易所账号信息", notes = "ROLE:SERVICE")
//    @ApiImplicitParam(paramType = "query", name = "exId", value = "交易所id", required = true)
//    @ApiResponses({
//            @ApiResponse(code = 200, message = "获取成功"),
//            @ApiResponse(code = 500, message = "获取失败")
//    })
//    public CommonResult<List<CoinExchangeAccountResponse>> getUserCoinExchangeAccount(Long userId, Long exId) {
//        List<CoinExchangeAccountBo> coinExchangeAccountBos = exchangeService.getCoinExchangeAccount(userId, exId);
//        List<CoinExchangeAccountResponse> coinExchangeAccountResponses = responseMapStruct.coinExchangeAccountBoList2ResponseList(coinExchangeAccountBos);
//        return CommonResult.success(coinExchangeAccountResponses);
//    }
//
//    @Override
//    @ApiOperation(value ="添加用户的交易账号信息", notes = "ROLE:ADMIN,USER,BOSS")
//    @ApiImplicitParam(paramType = "body", name = "addCoinExchangeAccountRequest", value = "添加请求体", required = true)
//    @ApiResponses({
//            @ApiResponse(code = 200, message = "添加成功"),
//            @ApiResponse(code = 500, message = "添加失败")
//    })
//    public CommonResult<String> addUserCoinExchangeAccount(String userInfo, AddCoinExchangeAccountRequest addCoinExchangeAccountRequest) {
//        HeaderUserInfo headerUserInfo = JsonToObject.jsonToClass(userInfo, HeaderUserInfo.class);
//        exchangeService.addCoinExchangeAccount(headerUserInfo.getId(), requestMapStruct.addCoinExchangeAccountRequest2Bo(addCoinExchangeAccountRequest));
//        return CommonResult.success("添加成功");
//    }
//
//    @Override
//    @ApiOperation(value ="更新用户的交易账号信息", notes = "ROLE:ADMIN,USER,BOSS")
//    @ApiImplicitParam(paramType = "body", name = "upCoinExchangeAccountRequest", value = "更新请求体", required = true)
//    @ApiResponses({
//            @ApiResponse(code = 200, message = "更新成功"),
//            @ApiResponse(code = 500, message = "更新失败")
//    })
//    public CommonResult<String> upUserCoinExchangeAccount(String userInfo, UpCoinExchangeAccountRequest upCoinExchangeAccountRequest) {
//        HeaderUserInfo headerUserInfo = JsonToObject.jsonToClass(userInfo, HeaderUserInfo.class);
//        exchangeService.upCoinExchangeAccount(headerUserInfo.getId(), requestMapStruct.upCoinExchangeAccountRequest2Bo(upCoinExchangeAccountRequest));
//        return CommonResult.success("更新成功");
//    }

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

    @Override
    @ApiOperation(value ="删除用户的交易账号信息", notes = "ROLE:ADMIN,BOSS")
    @ApiImplicitParam(paramType = "query", name = "exAccId", value = "交易账号id", required = true)
    @ApiResponses({
            @ApiResponse(code = 200, message = "删除成功"),
            @ApiResponse(code = 500, message = "删除失败")
    })
    public CommonResult<String> addFinanceFile(String userInfo, Integer id, String title, MultipartFile file) {
        HeaderUserInfo headerUserInfo = JsonToObject.jsonToClass(userInfo, HeaderUserInfo.class);
        exchangeService.addFinanceFile(id,title,file);
        return CommonResult.success("添加成功");
    }

    @Override
    @ApiOperation(value ="删除用户的交易账号信息", notes = "ROLE:ADMIN,BOSS")
    @ApiImplicitParam(paramType = "query", name = "exAccId", value = "交易账号id", required = true)
    @ApiResponses({
            @ApiResponse(code = 200, message = "删除成功"),
            @ApiResponse(code = 500, message = "删除失败")
    })
    public CommonResult<String> addQuarter(String userInfo, QuarterRequest quarterRequest) {
        HeaderUserInfo headerUserInfo = JsonToObject.jsonToClass(userInfo, HeaderUserInfo.class);
        exchangeService.addQuarter(requestMapStruct.quarterRequest2Bo(quarterRequest));
        return CommonResult.success("添加成功");
    }

    @Override
    @ApiOperation(value ="删除用户的交易账号信息", notes = "ROLE:ADMIN,USER,BOSS")
    @ApiImplicitParam(paramType = "query", name = "exAccId", value = "交易账号id", required = true)
    @ApiResponses({
            @ApiResponse(code = 200, message = "删除成功"),
            @ApiResponse(code = 500, message = "删除失败")
    })
    public CommonResult<List<QuarterPo>> getQuarter() {
        return CommonResult.success(exchangeService.getQuarter());
    }

    @Override
    @ApiOperation(value ="删除用户的交易账号信息", notes = "ROLE:ADMIN,USER,BOSS")
    @ApiImplicitParam(paramType = "query", name = "exAccId", value = "交易账号id", required = true)
    @ApiResponses({
            @ApiResponse(code = 200, message = "删除成功"),
            @ApiResponse(code = 500, message = "删除失败")
    })
    public CommonResult<List<QuarterPo>> getFinanceFile(String userInfo) {
        HeaderUserInfo headerUserInfo = JsonToObject.jsonToClass(userInfo, HeaderUserInfo.class);
        List<QuarterPo> financePos =  exchangeService.getFinanceFile();
        return CommonResult.success(financePos);
    }

    @Override
    @ApiOperation(value ="删除用户的交易账号信息", notes = "ROLE:ADMIN,USER,BOSS")
    @ApiImplicitParam(paramType = "query", name = "exAccId", value = "交易账号id", required = true)
    @ApiResponses({
            @ApiResponse(code = 200, message = "删除成功"),
            @ApiResponse(code = 500, message = "删除失败")
    })
    public CommonResult<String> addFavoriteFile(String userInfo, Integer financialId) {
        HeaderUserInfo headerUserInfo = JsonToObject.jsonToClass(userInfo, HeaderUserInfo.class);
        exchangeService.addFavoriteFile(headerUserInfo.getId(), financialId);
        return CommonResult.success("添加成功");
    }

    @Override
    @ApiOperation(value ="删除用户的交易账号信息", notes = "ROLE:ADMIN,USER,BOSS")
    @ApiImplicitParam(paramType = "query", name = "exAccId", value = "交易账号id", required = true)
    @ApiResponses({
            @ApiResponse(code = 200, message = "删除成功"),
            @ApiResponse(code = 500, message = "删除失败")
    })
    public CommonResult<List<QuarterPo>> getFavoriteFile(String userInfo) {
        HeaderUserInfo headerUserInfo = JsonToObject.jsonToClass(userInfo, HeaderUserInfo.class);
        return CommonResult.success(exchangeService.getFavoriteFile(headerUserInfo.getId()));
    }

    @Override
    @ApiOperation(value ="删除用户的交易账号信息", notes = "ROLE:ADMIN,USER,BOSS")
    @ApiImplicitParam(paramType = "query", name = "exAccId", value = "交易账号id", required = true)
    @ApiResponses({
            @ApiResponse(code = 200, message = "删除成功"),
            @ApiResponse(code = 500, message = "删除失败")
    })
    public CommonResult<String> delFavoriteFile(String userInfo, Integer id) {
        HeaderUserInfo headerUserInfo = JsonToObject.jsonToClass(userInfo, HeaderUserInfo.class);
        exchangeService.delFavoriteFile(headerUserInfo.getId(), id);
        return CommonResult.success("删除成功");
    }

    @Override
    @ApiOperation(value ="删除用户的交易账号信息", notes = "ROLE:ADMIN,BOSS")
    @ApiImplicitParam(paramType = "query", name = "exAccId", value = "交易账号id", required = true)
    @ApiResponses({
            @ApiResponse(code = 200, message = "删除成功"),
            @ApiResponse(code = 500, message = "删除失败")
    })
    public CommonResult<String> addNews(String userInfo, MultipartFile file, String title, String content) {
        HeaderUserInfo headerUserInfo = JsonToObject.jsonToClass(userInfo, HeaderUserInfo.class);
        exchangeService.addNews(headerUserInfo.getId(), file, title, content);
        return CommonResult.success("添加成功");
    }

    @Override
    @ApiOperation(value ="删除用户的交易账号信息", notes = "ROLE:ADMIN,BOSS")
    @ApiImplicitParam(paramType = "query", name = "exAccId", value = "交易账号id", required = true)
    @ApiResponses({
            @ApiResponse(code = 200, message = "删除成功"),
            @ApiResponse(code = 500, message = "删除失败")
    })
    public CommonResult<String> delNews(String userInfo, Integer newsId) {
        HeaderUserInfo headerUserInfo = JsonToObject.jsonToClass(userInfo, HeaderUserInfo.class);
        exchangeService.delNews(headerUserInfo.getId(), newsId);
        return CommonResult.success("删除成功");
    }

    @Override
    @ApiOperation(value ="删除用户的交易账号信息", notes = "ROLE:ADMIN,USER,BOSS")
    @ApiImplicitParam(paramType = "query", name = "exAccId", value = "交易账号id", required = true)
    @ApiResponses({
            @ApiResponse(code = 200, message = "删除成功"),
            @ApiResponse(code = 500, message = "删除失败")
    })
    public CommonResult<List<NewsPo>> getNews() {
        return CommonResult.success( exchangeService.getNews());
    }

    @Override
    @ApiOperation(value ="删除用户的交易账号信息", notes = "ROLE:ADMIN,USER,BOSS")
    @ApiImplicitParam(paramType = "query", name = "exAccId", value = "交易账号id", required = true)
    @ApiResponses({
            @ApiResponse(code = 200, message = "删除成功"),
            @ApiResponse(code = 500, message = "删除失败")
    })
    public CommonResult<List<NewsPo>> getSearchNews(String userInfo, String keywords) {
        return CommonResult.success( exchangeService.getSearchNews(keywords));
    }

    @Override
    @ApiOperation(value ="删除用户的交易账号信息", notes = "ROLE:ADMIN,USER,BOSS")
    @ApiImplicitParam(paramType = "query", name = "exAccId", value = "交易账号id", required = true)
    @ApiResponses({
            @ApiResponse(code = 200, message = "删除成功"),
            @ApiResponse(code = 500, message = "删除失败")
    })
    public CommonResult<String> addNewsLike(String userInfo, Integer newsId) {
        HeaderUserInfo headerUserInfo = JsonToObject.jsonToClass(userInfo, HeaderUserInfo.class);
        exchangeService.addNewsLike(headerUserInfo.getId(), newsId);
        return CommonResult.success("添加成功");
    }

    @Override
    @ApiOperation(value ="删除用户的交易账号信息", notes = "ROLE:ADMIN,USER,BOSS")
    @ApiImplicitParam(paramType = "query", name = "exAccId", value = "交易账号id", required = true)
    @ApiResponses({
            @ApiResponse(code = 200, message = "删除成功"),
            @ApiResponse(code = 500, message = "删除失败")
    })
    public CommonResult<String> delNewsLike(String userInfo, Integer newsId) {
        HeaderUserInfo headerUserInfo = JsonToObject.jsonToClass(userInfo, HeaderUserInfo.class);
        exchangeService.delNewsLike(headerUserInfo.getId(), newsId);
        return CommonResult.success("删除成功");
    }

    @Override
    @ApiOperation(value ="删除用户的交易账号信息", notes = "ROLE:ADMIN,BOSS")
    @ApiImplicitParam(paramType = "query", name = "exAccId", value = "交易账号id", required = true)
    @ApiResponses({
            @ApiResponse(code = 200, message = "删除成功"),
            @ApiResponse(code = 500, message = "删除失败")
    })
    public CommonResult<List<UserInfoPo>> getAllUserInfo() {
        return CommonResult.success(exchangeService.getAllUserInfo());
    }

    @Override
    @ApiOperation(value ="删除用户的交易账号信息", notes = "ROLE:ADMIN,BOSS")
    @ApiImplicitParam(paramType = "query", name = "exAccId", value = "交易账号id", required = true)
    @ApiResponses({
            @ApiResponse(code = 200, message = "删除成功"),
            @ApiResponse(code = 500, message = "删除失败")
    })
    public CommonResult<String> upUserDisabled(String userInfo, Long userId) {
        HeaderUserInfo headerUserInfo = JsonToObject.jsonToClass(userInfo, HeaderUserInfo.class);
        exchangeService.upUserDisabled(userId);
        return CommonResult.success("更新成功");
    }

    @Override
    @ApiOperation(value ="删除用户的交易账号信息", notes = "ROLE:ADMIN,BOSS")
    @ApiImplicitParam(paramType = "query", name = "exAccId", value = "交易账号id", required = true)
    @ApiResponses({
            @ApiResponse(code = 200, message = "删除成功"),
            @ApiResponse(code = 500, message = "删除失败")
    })
    public CommonResult<String> upUserEnabled(String userInfo, Long userId) {
        HeaderUserInfo headerUserInfo = JsonToObject.jsonToClass(userInfo, HeaderUserInfo.class);
        exchangeService.upUserEnabled(userId);
        return CommonResult.success("更新成功");    }

    @Override
    @ApiOperation(value ="删除用户的交易账号信息", notes = "ROLE:ADMIN,BOSS")
    @ApiImplicitParam(paramType = "query", name = "exAccId", value = "交易账号id", required = true)
    @ApiResponses({
            @ApiResponse(code = 200, message = "删除成功"),
            @ApiResponse(code = 500, message = "删除失败")
    })
    public CommonResult<List<UserInfoPo>> searchUser(String username) {
        return CommonResult.success(exchangeService.searchUser(username));
    }

    @Override
    @ApiOperation(value ="删除用户的交易账号信息", notes = "ROLE:ADMIN,BOSS")
    @ApiImplicitParam(paramType = "query", name = "exAccId", value = "交易账号id", required = true)
    @ApiResponses({
            @ApiResponse(code = 200, message = "删除成功"),
            @ApiResponse(code = 500, message = "删除失败")
    })
    public CommonResult<String> addStock(String symbol, Integer code) {
        exchangeService.addStock(symbol, code);
        return CommonResult.success("添加成功");
    }

    @Override
    @ApiOperation(value ="删除用户的交易账号信息", notes = "ROLE:ADMIN,USER,BOSS")
    @ApiImplicitParam(paramType = "query", name = "exAccId", value = "交易账号id", required = true)
    @ApiResponses({
            @ApiResponse(code = 200, message = "删除成功"),
            @ApiResponse(code = 500, message = "删除失败")
    })
    public CommonResult<List<StockPo>> getStock() {
        return CommonResult.success(exchangeService.getStock());
    }

    @Override
    @ApiOperation(value ="删除用户的交易账号信息", notes = "ROLE:ADMIN,BOSS")
    @ApiImplicitParam(paramType = "query", name = "exAccId", value = "交易账号id", required = true)
    @ApiResponses({
            @ApiResponse(code = 200, message = "删除成功"),
            @ApiResponse(code = 500, message = "删除失败")
    })
    public CommonResult<String> delStock(Integer id) {
        exchangeService.delStock(id);
        return CommonResult.success("删除成功");
    }

    @Override
    @ApiOperation(value ="删除用户的交易账号信息", notes = "ROLE:ADMIN,USER,BOSS")
    @ApiImplicitParam(paramType = "query", name = "exAccId", value = "交易账号id", required = true)
    @ApiResponses({
            @ApiResponse(code = 200, message = "删除成功"),
            @ApiResponse(code = 500, message = "删除失败")
    })
    public CommonResult<List<StockHistoryPo>> getStockHistory(String stockId, Integer scale, Long timestamp) {
        return CommonResult.success(exchangeService.getStockHistory(stockId, scale, timestamp));
    }

}
