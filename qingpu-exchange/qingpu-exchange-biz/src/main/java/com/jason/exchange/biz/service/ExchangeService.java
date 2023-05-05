package com.jason.exchange.biz.service;

import com.jason.exchange.biz.bo.QuarterBo;
import com.jason.exchange.biz.po.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author：yangwushuo
 * @time：2022/11/17 15:01
 */
public interface ExchangeService {

    void delCoinExchangeAccount(Long userId, Long exAccId);

    void addQuarter(QuarterBo quarterBo);

    List<QuarterPo> getQuarter();

    void addFinanceFile(Integer id, String title, MultipartFile file);

    List<QuarterPo> getFinanceFile();

    void addFavoriteFile(Long userId, Integer financialId);

    List<QuarterPo> getFavoriteFile(Long userId);

    void delFavoriteFile(Long userId, Integer fid);

    void addNews(Long userId, MultipartFile file, String title, String content);

    void delNews(Long userId, Integer newsId);

    List<NewsPo> getNews();

    List<NewsPo> getSearchNews(String keywords);

    void addNewsLike(Long userId, Integer newsId);

    void delNewsLike(Long userId, Integer newsId);

    List<UserInfoPo> getAllUserInfo();

    void upUserDisabled(Long userId);

    void upUserEnabled(Long userId);

    List<UserInfoPo> searchUser(String username);

    void addStock(String symbol, Integer code);

    List<StockPo> getStock();

    void delStock(Integer id);

    List<StockHistoryPo> getStockHistory(String stockId, Integer scale, Long timestamp);

}
