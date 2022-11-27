package com.jason.exchange.biz.service.impl;

import com.jason.binance.api.request.BinanceKeyRequest;
import com.jason.binance.api.service.BinanceRemoteService;
import com.jason.common.Result.CommonResult;
import com.jason.common.exception.AddException;
import com.jason.common.exception.DelException;
import com.jason.common.exception.GetException;
import com.jason.common.exception.UpException;
import com.jason.exchange.biz.bo.AddCoinExchangeAccountBo;
import com.jason.exchange.biz.bo.CoinExchangeAccountBo;
import com.jason.exchange.biz.bo.CoinExchangeBo;
import com.jason.exchange.biz.bo.UpCoinExchangeAccountBo;
import com.jason.exchange.biz.dao.ExchangeDao;
import com.jason.exchange.biz.mapstruct.CoinExchangeMapStruct;
import com.jason.exchange.biz.po.*;
import com.jason.exchange.biz.service.ExchangeService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author：yangwushuo
 * @time：2022/11/17 15:01
 */
@Service
public class ExchangeServiceImpl implements ExchangeService {

    private final ExchangeDao exchangeDao;

    private final BinanceRemoteService binanceRemoteService;

    private final CoinExchangeMapStruct coinExchangeMapStruct;

    public ExchangeServiceImpl(ExchangeDao exchangeDao, BinanceRemoteService binanceRemoteService, CoinExchangeMapStruct coinExchangeMapStruct) {
        this.exchangeDao = exchangeDao;
        this.binanceRemoteService = binanceRemoteService;
        this.coinExchangeMapStruct = coinExchangeMapStruct;
    }

    @Override
    public List<CoinExchangeBo> getAllCoinExchange() {
        List<CoinExchangePo> coinExchangePoList = exchangeDao.getAllExchange();
        List<CoinExchangeBo> coinExchangeBoList = coinExchangeMapStruct.coinExchangePoList2BoList(coinExchangePoList);
        return coinExchangeBoList;
    }

    @Override
    public List<CoinExchangeAccountBo> getCoinExchangeAccount(Long userId, Long exId) {

        if (userId == null || userId < 0){
            throw new GetException("参数错误,获取失败");
        }

        List<CoinExchangeAccountPo> coinExchangeAccountPos = exchangeDao.getCoinExchangeAccountById(userId, exId);
        System.out.println(coinExchangeAccountPos);
        List<CoinExchangeAccountBo> coinExchangeAccountBos = coinExchangeMapStruct.coinExchangeAccountPoList2BoList(coinExchangeAccountPos);
        System.out.println(coinExchangeAccountBos);
        return coinExchangeAccountBos;
    }

    @Override
    public void upCoinExchangeAccount(Long userId, UpCoinExchangeAccountBo upCoinExchangeAccountBo) {

        if (userId == null || userId < 0 || upCoinExchangeAccountBo.getExchangeAccountId() == null || upCoinExchangeAccountBo.getExchangeAccountId() < 0){
            throw new UpException("参数错误,更新失败");
        }

        //判断该用户是否拥有此交易账户
        Integer accNum = exchangeDao.getCoinExchangeAccountNumById(userId, upCoinExchangeAccountBo.getExchangeAccountId());
        if (accNum != 1){
            throw new UpException("参数错误,更新失败");
        }

        //更新账号
        UpCoinExchangeAccountPo upCoinExchangeAccountPo = coinExchangeMapStruct.upCoinExchangeAccountBo2Po(upCoinExchangeAccountBo);
        exchangeDao.upCoinExchangeAccountById(userId, upCoinExchangeAccountPo);

    }

    @Override
    public void delCoinExchangeAccount(Long userId, Long exAccId) {

        if (userId == null || userId < 0 || exAccId == null || exAccId < 0){
            throw new DelException("参数错误,删除失败");
        }

        //判断该用户是否拥有此交易账户
        Integer accNum = exchangeDao.getCoinExchangeAccountNumById(userId, exAccId);
        if (accNum != 1){
            throw new DelException("账户错误");
        }

        exchangeDao.delCoinExchangeAccountById(userId, exAccId);

    }

    @Override
    public void addCoinExchangeAccount(Long userId, AddCoinExchangeAccountBo addCoinExchangeAccountBo) {

        if (
                userId == null ||
                userId < 0 ||
                addCoinExchangeAccountBo.getApiKey() == null ||
                addCoinExchangeAccountBo.getApiKey().length() <= 0 ||
                addCoinExchangeAccountBo.getSecretKey() == null ||
                addCoinExchangeAccountBo.getSecretKey().length() <= 0
        ){
            throw new AddException("参数错误,添加失败");
        }

        //判断交易所
        List<CoinExchangePo> allExchange = exchangeDao.getAllExchange();
        if(allExchange != null && allExchange.size() > 0){
            int i = 0;
            for (; i < allExchange.size(); i++) {
                if (allExchange.get(i).getId() == addCoinExchangeAccountBo.getExchangeId()){
                    break;
                }
            }
            if (i == allExchange.size()){
                throw new AddException("交易所错误");
            }
        }


        //获取该用户所有交易账户key
        List<CoinExchangeAccountKeyPo> coinExchangeAccountKeyPoList = exchangeDao.getCoinExchangeAccountKeyListById(userId);
        for (int i = 0; i < coinExchangeAccountKeyPoList.size(); i++) {
            //apikey相等
            if (coinExchangeAccountKeyPoList.get(i).getApiKey().equals(addCoinExchangeAccountBo.getApiKey())){
                throw new AddException("重复添加");
            }
        }

        //判断该添加账户是否只读
        BinanceKeyRequest binanceKeyRequest = BinanceKeyRequest.builder()
                .apiKey(addCoinExchangeAccountBo.getApiKey())
                .secretKey(addCoinExchangeAccountBo.getSecretKey())
                .build();
        CommonResult<String> orderTestRes = binanceRemoteService.orderTest(binanceKeyRequest);
        if (orderTestRes.getCode() == 200){
            throw new AddException("密钥对不是只读,请修改只读权限再尝试");
        }
        System.out.println(orderTestRes);

        //添加账号
        AddCoinExchangeAccountPo addCoinExchangeAccountPo = coinExchangeMapStruct.addCoinExchangeAccountBo2Po(addCoinExchangeAccountBo);
        Long createTime = System.currentTimeMillis();
        exchangeDao.addCoinExchangeAccount(userId, createTime, addCoinExchangeAccountPo);
        exchangeDao.addCoinExchangeAccountPer(addCoinExchangeAccountPo);

    }

    @Override
    public String getBinanceSpotAccountInfo(Long userId, Long exAccId) {
        if (userId == null || userId < 0 || exAccId == null || exAccId < 0){
            throw new GetException("参数错误,删除失败");
        }

        CoinExchangeAccountKeyPo coinExchangeAccountKey = exchangeDao.getCoinExchangeAccountKeyById(userId, exAccId);
        BinanceKeyRequest binanceKeyRequest = BinanceKeyRequest.builder()
                .apiKey(coinExchangeAccountKey.getApiKey())
                .secretKey(coinExchangeAccountKey.getSecretKey())
                .build();

        CommonResult<String> remoteRes = binanceRemoteService.accountInfo(binanceKeyRequest);
        if (remoteRes.getCode() != 200){
            throw new GetException("获取失败");
        }

        return remoteRes.getData();
    }

}
