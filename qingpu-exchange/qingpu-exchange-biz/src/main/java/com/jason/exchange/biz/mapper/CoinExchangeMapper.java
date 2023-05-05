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

    void addQuarter(@Param("q")QuarterPo quarterPo);

    List<QuarterPo> getQuarter();

    void addFinanceFile(Integer id, String title, String url);

    List<FinancePo> getFinance(Integer id);

    void addFavoriteFile(Long userId, Integer financialId);

    List<FavoriteFilesPo> getFavoriteFile(Long userId);

    void delFavoriteFile(Long userId, Integer fid);

    void addNews(Long userId, String url, String title, String content);

    void delNews(Long userId, Integer newsId);

    List<NewsPo> getNews();

    List<NewsPo> getSearchNews(String keywords);

    UserInfoPo getUserInfo(Long userId);

    List<Long> getNewsLike(Integer newsId);

    void addNewsLike(Long userId, Integer newsId);

    void delNewsLike(Long userId, Integer newsId);

    List<UserInfoPo> getAllUserInfo();

    void upUserDisabled(Long userId);

    void upUserEnabled(Long userId);

    List<UserInfoPo> searchUser(String username);

    void addStock(String symbol, Integer code);

    List<StockPo> getStock();

    void delStock(Integer id);

}
