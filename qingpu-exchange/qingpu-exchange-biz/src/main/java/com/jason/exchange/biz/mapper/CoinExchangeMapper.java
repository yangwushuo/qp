package com.jason.exchange.biz.mapper;

import com.jason.exchange.biz.po.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author：yangwushuo
 * @time：2022/11/17 18:59
 */
@Mapper
public interface CoinExchangeMapper {

    List<CoinExchangePo> getAllCoinExchange();

    CoinExchangePo getCoinExchange(@Param("exId") Long exId);

    List<CoinExchangeAccountPo> getCoinExchangeAccountById(@Param("userId") Long userId, @Param("exId") Long exId);

    CoinExchangeAccountPerPo getCoinExchangeAccountPerById(@Param("exAccId") Long exAccId);

    Integer getUserExchangeAccountNumById(@Param("userId")Long userId, @Param("exAccId") Long exAccId);

    void upCoinExchangeAccountById(@Param("userId") Long userId, @Param("upCoinExAcc") UpCoinExchangeAccountPo upCoinExchangeAccountPo);

    void delCoinExchangeAccountById(@Param("userId") Long userId, @Param("exAccId") Long exAccId);

    CoinExchangeAccountKeyPo getCoinExchangeAccountKeyById(@Param("userId") Long userId, @Param("exAccId") Long exAccId);

    List<CoinExchangeAccountKeyPo> getCoinExchangeAccountKeyListById(@Param("userId") Long userId);

    void addCoinExchangeAccount(@Param("userId") Long userId,@Param("createTime") Long createTime, @Param("addExAcc") AddCoinExchangeAccountPo addCoinExchangeAccountPo);

    void addCoinExchangeAccountPer(@Param("addExAcc") AddCoinExchangeAccountPo addCoinExchangeAccountPo);
}
