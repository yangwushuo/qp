package com.jason.exchange.biz.dao;

import com.jason.exchange.biz.bo.AddCoinExchangeAccountBo;
import com.jason.exchange.biz.bo.CoinExchangeAccountBo;
import com.jason.exchange.biz.po.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author：yangwushuo
 * @time：2022/11/17 18:56
 */
public interface ExchangeDao {

    List<CoinExchangePo> getAllExchange();

    List<CoinExchangeAccountPo> getCoinExchangeAccountById(Long userId, Long exId);

    Integer getCoinExchangeAccountNumById(Long userId, Long exAccId);

    void upCoinExchangeAccountById(Long userId, UpCoinExchangeAccountPo upCoinExchangeAccountPo);

    void delCoinExchangeAccountById(Long userId, Long exAccId);

    CoinExchangeAccountKeyPo getCoinExchangeAccountKeyById(Long userId, Long exAccId);

    List<CoinExchangeAccountKeyPo> getCoinExchangeAccountKeyListById(Long userId);

    void addCoinExchangeAccount(Long userId, Long createTime, AddCoinExchangeAccountPo addCoinExchangeAccountPo);

    void addCoinExchangeAccountPer(AddCoinExchangeAccountPo addCoinExchangeAccountPo);

}
