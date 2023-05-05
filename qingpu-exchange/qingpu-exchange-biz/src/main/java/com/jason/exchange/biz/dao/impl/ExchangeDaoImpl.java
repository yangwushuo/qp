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
    public void addQuarter(QuarterPo quarterPo) {
        coinExchangeMapper.addQuarter(quarterPo);
    }

    @Override
    public List<QuarterPo> getQuarter() {
        return coinExchangeMapper.getQuarter();
    }

    @Override
    public void addFinanceFile(Integer id, String title, String url) {
        coinExchangeMapper.addFinanceFile(id, title, url);
    }

    @Override
    public List<FinancePo> getFinance(Integer id) {
        return coinExchangeMapper.getFinance(id);
    }

    @Override
    public void addFavoriteFile(Long userId, Integer financialId) {
        coinExchangeMapper.addFavoriteFile(userId, financialId);
    }

    @Override
    public List<FavoriteFilesPo> getFavoriteFile(Long userId) {
        return coinExchangeMapper.getFavoriteFile(userId);
    }

    @Override
    public void delFavoriteFile(Long userId, Integer fid) {
        coinExchangeMapper.delFavoriteFile(userId, fid);
    }

    @Override
    public void addNews(Long userId, String url, String title, String content) {
        coinExchangeMapper.addNews(userId, url, title, content);
    }

    @Override
    public void delNews(Long userId, Integer newsId) {
        coinExchangeMapper.delNews(userId, newsId);
    }

    @Override
    public List<NewsPo> getNews() {
        return coinExchangeMapper.getNews();
    }

    @Override
    public List<NewsPo> getSearchNews(String keywords) {
        return coinExchangeMapper.getSearchNews(keywords);
    }

    @Override
    public UserInfoPo getUserInfo(Long userId) {
        return coinExchangeMapper.getUserInfo(userId);
    }

    @Override
    public List<Long> getNewsLike(Integer newsId) {
        return coinExchangeMapper.getNewsLike(newsId);
    }

    @Override
    public void addNewsLike(Long userId, Integer newsId) {
        coinExchangeMapper.addNewsLike(userId,newsId);
    }

    @Override
    public void delNewsLike(Long userId, Integer newsId) {
        coinExchangeMapper.delNewsLike(userId, newsId);
    }

    @Override
    public List<UserInfoPo> getAllUserInfo() {
        return coinExchangeMapper.getAllUserInfo();
    }

    @Override
    public void upUserDisabled(Long userId) {
        coinExchangeMapper.upUserDisabled(userId);
    }

    @Override
    public void upUserEnabled(Long userId) {
        coinExchangeMapper.upUserEnabled(userId);
    }

    @Override
    public List<UserInfoPo> searchUser(String username) {
        return coinExchangeMapper.searchUser(username);
    }

    @Override
    public void addStock(String symbol, Integer code) {
        coinExchangeMapper.addStock(symbol, code);
    }

    @Override
    public List<StockPo> getStock() {
        return coinExchangeMapper.getStock();
    }

    @Override
    public void delStock(Integer id) {
        coinExchangeMapper.delStock(id);
    }

//    @Override
//    public List<CoinExchangePo> getAllExchange() {
//        return coinExchangeMapper.getAllCoinExchange();
//    }
//
//    @Override
//    public List<CoinExchangeAccountPo> getCoinExchangeAccountById(Long userId, Long exId) {
//        return coinExchangeMapper.getCoinExchangeAccountById(userId, exId);
//    }
//
//    @Override
//    public Integer getCoinExchangeAccountNumById(Long userId, Long exAccId) {
//        return coinExchangeMapper.getUserExchangeAccountNumById(userId, exAccId);
//    }
//
//    @Override
//    public void upCoinExchangeAccountById(Long userId, UpCoinExchangeAccountPo upCoinExchangeAccountPo) {
//        coinExchangeMapper.upCoinExchangeAccountById(userId, upCoinExchangeAccountPo);
//    }
//
//    @Override
//    public void delCoinExchangeAccountById(Long userId, Long exAccId) {
//        coinExchangeMapper.delCoinExchangeAccountById(userId,exAccId);
//    }
//
//    @Override
//    public CoinExchangeAccountKeyPo getCoinExchangeAccountKeyById(Long userId, Long exAccId) {
//        return coinExchangeMapper.getCoinExchangeAccountKeyById(userId, exAccId);
//    }
//
//    @Override
//    public List<CoinExchangeAccountKeyPo> getCoinExchangeAccountKeyListById(Long userId) {
//        return coinExchangeMapper.getCoinExchangeAccountKeyListById(userId);
//    }
//
//    @Override
//    public void addCoinExchangeAccount(Long userId, Long createTime, AddCoinExchangeAccountPo addCoinExchangeAccountPo) {
//        coinExchangeMapper.addCoinExchangeAccount(userId, createTime, addCoinExchangeAccountPo);
//    }
//
//    @Override
//    public void addCoinExchangeAccountPer(AddCoinExchangeAccountPo addCoinExchangeAccountPo) {
//        coinExchangeMapper.addCoinExchangeAccountPer(addCoinExchangeAccountPo);
//    }

}
