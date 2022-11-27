package com.jason.exchange.biz.dao.impl;

import com.jason.exchange.biz.dao.ExchangeDao;
import com.jason.exchange.biz.mapper.CoinExchangeMapper;
import com.jason.exchange.biz.po.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author：yangwushuo
 * @time：2022/11/17 18:57
 */
@Repository
public class ExchangeDaoImpl implements ExchangeDao {

    private final CoinExchangeMapper coinExchangeMapper;

    public ExchangeDaoImpl(CoinExchangeMapper coinExchangeMapper) {
        this.coinExchangeMapper = coinExchangeMapper;
    }

    @Override
    public List<CoinExchangePo> getAllExchange() {
        return coinExchangeMapper.getAllCoinExchange();
    }

    @Override
    public List<CoinExchangeAccountPo> getCoinExchangeAccountById(Long userId, Long exId) {
        return coinExchangeMapper.getCoinExchangeAccountById(userId, exId);
    }

    @Override
    public Integer getCoinExchangeAccountNumById(Long userId, Long exAccId) {
        return coinExchangeMapper.getUserExchangeAccountNumById(userId, exAccId);
    }

    @Override
    public void upCoinExchangeAccountById(Long userId, UpCoinExchangeAccountPo upCoinExchangeAccountPo) {
        coinExchangeMapper.upCoinExchangeAccountById(userId, upCoinExchangeAccountPo);
    }

    @Override
    public void delCoinExchangeAccountById(Long userId, Long exAccId) {
        coinExchangeMapper.delCoinExchangeAccountById(userId,exAccId);
    }

    @Override
    public CoinExchangeAccountKeyPo getCoinExchangeAccountKeyById(Long userId, Long exAccId) {
        return coinExchangeMapper.getCoinExchangeAccountKeyById(userId, exAccId);
    }

    @Override
    public List<CoinExchangeAccountKeyPo> getCoinExchangeAccountKeyListById(Long userId) {
        return coinExchangeMapper.getCoinExchangeAccountKeyListById(userId);
    }

    @Override
    public void addCoinExchangeAccount(Long userId, Long createTime, AddCoinExchangeAccountPo addCoinExchangeAccountPo) {
        coinExchangeMapper.addCoinExchangeAccount(userId, createTime, addCoinExchangeAccountPo);
    }

    @Override
    public void addCoinExchangeAccountPer(AddCoinExchangeAccountPo addCoinExchangeAccountPo) {
        coinExchangeMapper.addCoinExchangeAccountPer(addCoinExchangeAccountPo);
    }

}
