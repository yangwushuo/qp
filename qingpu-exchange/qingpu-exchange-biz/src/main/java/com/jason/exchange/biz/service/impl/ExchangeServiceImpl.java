package com.jason.exchange.biz.service.impl;

import com.google.gson.*;
import com.jason.common.exception.UpException;
import com.jason.exchange.biz.bo.QuarterBo;
import com.jason.exchange.biz.dao.ExchangeDao;
import com.jason.exchange.biz.mapstruct.CoinExchangeMapStruct;
import com.jason.exchange.biz.po.*;
import com.jason.exchange.biz.service.ExchangeService;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author：yangwushuo
 * @time：2022/11/17 15:01
 */
@Service
public class ExchangeServiceImpl implements ExchangeService {

    private final ExchangeDao exchangeDao;

    private final CoinExchangeMapStruct coinExchangeMapStruct;

    private final OssServiceImpl ossService;

    private final RestTemplate restTemplate;


    public ExchangeServiceImpl(OssServiceImpl ossService, ExchangeDao exchangeDao, CoinExchangeMapStruct coinExchangeMapStruct,RestTemplate restTemplate) {
        this.ossService = ossService;
        this.exchangeDao = exchangeDao;
        this.coinExchangeMapStruct = coinExchangeMapStruct;
        this.restTemplate = restTemplate;
    }

    @Override
    public void delCoinExchangeAccount(Long userId, Long exAccId) {

    }

    @Override
    public void addQuarter(QuarterBo quarterBo) {
        QuarterPo quarterPo = coinExchangeMapStruct.quarterBo2Po(quarterBo);
        exchangeDao.addQuarter(quarterPo);
    }

    @Override
    public List<QuarterPo> getQuarter() {
        return exchangeDao.getQuarter();
    }

    @Override
    public void addFinanceFile(Integer id, String title, MultipartFile file) {
        // 文件上传到oss
        String url = ossService.savePortrait(file);
        if(url == null){
            throw new UpException("更新用户头像失败");
        }
        exchangeDao.addFinanceFile(id, title, url);
    }

    @Override
    public List<QuarterPo> getFinanceFile() {
        List<QuarterPo> quarter = exchangeDao.getQuarter();
        for (int i = 0; i < quarter.size(); i++) {
            List<FinancePo> finance = exchangeDao.getFinance(quarter.get(i).getId());
            quarter.get(i).setFinancePos(finance);
        }
        return quarter;
    }

    @Override
    public void addFavoriteFile(Long userId, Integer financialId) {
        exchangeDao.addFavoriteFile(userId, financialId);
    }

    @Override
    public List<QuarterPo> getFavoriteFile(Long userId) {
        List<FavoriteFilesPo> favoriteFile = exchangeDao.getFavoriteFile(userId);
        List<QuarterPo> financeFile = getFinanceFile();
        List<QuarterPo> res = new ArrayList<>();
        for (int i = 0; i < financeFile.size(); i++) {
            List<FinancePo> financePos = financeFile.get(i).getFinancePos();
            for (int j = 0; j < financePos.size(); j++) {
                Integer id = financePos.get(j).getId();
                int k = 0;
                for (k = 0; k < favoriteFile.size(); k++) {
                    if(id == favoriteFile.get(k).getFinancial_report_id()) break;
                }
                if(k != favoriteFile.size()) res.add(financeFile.get(i));
            }
        }
        return res;
    }

    @Override
    public void delFavoriteFile(Long userId, Integer fid) {
        exchangeDao.delFavoriteFile(userId, fid);
    }

    @Override
    public void addNews(Long userId, MultipartFile file, String title, String content) {
        String url = "";
        if(file != null){
            url = ossService.savePortrait(file);
        }
        exchangeDao.addNews(userId, url, title, content);
    }

    @Override
    public void delNews(Long userId, Integer newsId) {
        exchangeDao.delNews(userId, newsId);
    }

    @Override
    public List<NewsPo> getNews() {
        List<NewsPo> news = exchangeDao.getNews();
        for (int i = 0; i < news.size(); i++) {
            UserInfoPo userInfo = exchangeDao.getUserInfo(news.get(i).getAdmin_id());
            List<Long> likeId = exchangeDao.getNewsLike(news.get(i).getId());
            news.get(i).setUserInfoPo(userInfo);
            news.get(i).setLikeId(likeId);
        }
        return news;
    }

    @Override
    public List<NewsPo> getSearchNews(String keywords) {
        List<NewsPo> news = exchangeDao.getSearchNews(keywords);
        for (int i = 0; i < news.size(); i++) {
            UserInfoPo userInfo = exchangeDao.getUserInfo(news.get(i).getAdmin_id());
            List<Long> likeId = exchangeDao.getNewsLike(news.get(i).getId());
            news.get(i).setUserInfoPo(userInfo);
            news.get(i).setLikeId(likeId);
        }
        return news;
    }

    @Override
    public void addNewsLike(Long userId, Integer newsId) {
        exchangeDao.addNewsLike(userId, newsId);
    }

    @Override
    public void delNewsLike(Long userId, Integer newsId) {
        exchangeDao.delNewsLike(userId, newsId);
    }

    @Override
    public List<UserInfoPo> getAllUserInfo() {
        return exchangeDao.getAllUserInfo();
    }

    @Override
    public void upUserDisabled(Long userId) {
        exchangeDao.upUserDisabled(userId);
    }

    @Override
    public void upUserEnabled(Long userId) {
        exchangeDao.upUserEnabled(userId);
    }

    @Override
    public List<UserInfoPo> searchUser(String username) {
        return exchangeDao.searchUser(username);
    }

    @Override
    public void addStock(String symbol, Integer code) {
        exchangeDao.addStock(symbol , code);
    }

    @Override
    public List<StockPo> getStock() {
        return exchangeDao.getStock();
    }

    @Override
    public void delStock(Integer id) {
        exchangeDao.delStock(id);
    }

    @Override
    public List<StockHistoryPo> getStockHistory(String stockId, Integer scale, Long timestamp) {
        String url = "https://quotes.sina.cn/cn/api/jsonp_v2.php/var%20_sh" + stockId+ "_"+scale+"_" +timestamp+ "=/CN_MarketDataService.getKLineData?symbol=sh"+stockId+"&scale="+scale+"&ma=no&datalen=1023";
        System.out.println(url);
        String res = restTemplate.getForObject(url,String.class);
        Pattern pattern = Pattern.compile("\\((.*)\\)");
        Matcher matcher = pattern.matcher(res);
        if (matcher.find()){
            String content = matcher.group(1);
            List<StockHistoryPo> historyPos = new ArrayList<>();
            Gson gson = new Gson();
            JsonArray jsonArray = JsonParser.parseString(content).getAsJsonArray();
            for (JsonElement jsonElement : jsonArray) {
                StockHistoryPo stockHistoryPo = gson.fromJson(jsonElement, StockHistoryPo.class);
                historyPos.add(stockHistoryPo);
            }
//            System.out.println(historyPos);
            return historyPos;
        }else{
            return null;
        }
    }

//    @Override
//    public List<CoinExchangeBo> getAllCoinExchange() {
//        List<CoinExchangePo> coinExchangePoList = exchangeDao.getAllExchange();
//        List<CoinExchangeBo> coinExchangeBoList = coinExchangeMapStruct.coinExchangePoList2BoList(coinExchangePoList);
//        return coinExchangeBoList;
//    }
//
//    @Override
//    public List<CoinExchangeAccountBo> getCoinExchangeAccount(Long userId, Long exId) {
//
//        if (userId == null || userId < 0){
//            throw new GetException("参数错误,获取失败");
//        }
//
//        List<CoinExchangeAccountPo> coinExchangeAccountPos = exchangeDao.getCoinExchangeAccountById(userId, exId);
//        System.out.println(coinExchangeAccountPos);
//        List<CoinExchangeAccountBo> coinExchangeAccountBos = coinExchangeMapStruct.coinExchangeAccountPoList2BoList(coinExchangeAccountPos);
//        System.out.println(coinExchangeAccountBos);
//        return coinExchangeAccountBos;
//    }
//
//    @Override
//    public void upCoinExchangeAccount(Long userId, UpCoinExchangeAccountBo upCoinExchangeAccountBo) {
//
//        if (userId == null || userId < 0 || upCoinExchangeAccountBo.getExchangeAccountId() == null || upCoinExchangeAccountBo.getExchangeAccountId() < 0){
//            throw new UpException("参数错误,更新失败");
//        }
//
//        //判断该用户是否拥有此交易账户
//        Integer accNum = exchangeDao.getCoinExchangeAccountNumById(userId, upCoinExchangeAccountBo.getExchangeAccountId());
//        if (accNum != 1){
//            throw new UpException("参数错误,更新失败");
//        }
//
//        //更新账号
//        UpCoinExchangeAccountPo upCoinExchangeAccountPo = coinExchangeMapStruct.upCoinExchangeAccountBo2Po(upCoinExchangeAccountBo);
//        exchangeDao.upCoinExchangeAccountById(userId, upCoinExchangeAccountPo);
//
//    }
//
//    @Override
//    public void delCoinExchangeAccount(Long userId, Long exAccId) {
//
//        if (userId == null || userId < 0 || exAccId == null || exAccId < 0){
//            throw new DelException("参数错误,删除失败");
//        }
//
//        //判断该用户是否拥有此交易账户
//        Integer accNum = exchangeDao.getCoinExchangeAccountNumById(userId, exAccId);
//        if (accNum != 1){
//            throw new DelException("账户错误");
//        }
//
//        exchangeDao.delCoinExchangeAccountById(userId, exAccId);
//
//    }
//
//    @Override
//    public void addCoinExchangeAccount(Long userId, AddCoinExchangeAccountBo addCoinExchangeAccountBo) {
//
//        if (
//                userId == null ||
//                userId < 0 ||
//                addCoinExchangeAccountBo.getApiKey() == null ||
//                addCoinExchangeAccountBo.getApiKey().length() <= 0 ||
//                addCoinExchangeAccountBo.getSecretKey() == null ||
//                addCoinExchangeAccountBo.getSecretKey().length() <= 0
//        ){
//            throw new AddException("参数错误,添加失败");
//        }
//
//        //判断交易所
//        List<CoinExchangePo> allExchange = exchangeDao.getAllExchange();
//        if(allExchange != null && allExchange.size() > 0){
//            int i = 0;
//            for (; i < allExchange.size(); i++) {
//                if (allExchange.get(i).getId() == addCoinExchangeAccountBo.getExchangeId()){
//                    break;
//                }
//            }
//            if (i == allExchange.size()){
//                throw new AddException("交易所错误");
//            }
//        }
//
//
//        //获取该用户所有交易账户key
//        List<CoinExchangeAccountKeyPo> coinExchangeAccountKeyPoList = exchangeDao.getCoinExchangeAccountKeyListById(userId);
//        for (int i = 0; i < coinExchangeAccountKeyPoList.size(); i++) {
//            //apikey相等
//            if (coinExchangeAccountKeyPoList.get(i).getApiKey().equals(addCoinExchangeAccountBo.getApiKey())){
//                throw new AddException("重复添加");
//            }
//        }
//
//        //判断该添加账户是否只读
//        BinanceParamRequest binanceParamRequest = BinanceParamRequest.builder()
//                .apiKey(addCoinExchangeAccountBo.getApiKey())
//                .secretKey(addCoinExchangeAccountBo.getSecretKey())
//                .build();
//        CommonResult<String> reqRes = binanceRemoteService.accountPer(binanceParamRequest);
//        if (reqRes.getCode() == 200 && reqRes.getData().length() > 0){
//            //解析
//            JSONObject jsonObject = JSONObject.parseObject(reqRes.getData());
//            Boolean enableReading = jsonObject.getBoolean("enableReading");
//            if (enableReading){
//                //添加账号
//                AddCoinExchangeAccountPo addCoinExchangeAccountPo = coinExchangeMapStruct.addCoinExchangeAccountBo2Po(addCoinExchangeAccountBo);
//                Long createTime = System.currentTimeMillis();
//                exchangeDao.addCoinExchangeAccount(userId, createTime, addCoinExchangeAccountPo);
//                exchangeDao.addCoinExchangeAccountPer(addCoinExchangeAccountPo);
//            }else{
//                throw new AddException("添加账号失败,账号非只读");
//            }
//        }else{
//            throw new AddException("添加账户失败");
//        }
//
//    }

}
