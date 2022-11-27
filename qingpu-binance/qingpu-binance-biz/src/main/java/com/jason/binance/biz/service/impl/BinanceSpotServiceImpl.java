package com.jason.binance.biz.service.impl;

import com.jason.binance.biz.enums.DefaultUrls;
import com.jason.binance.biz.service.BinanceSpotService;
import com.jason.binance.biz.service.impl.spot.*;
import org.springframework.stereotype.Service;

/**
 * @author：yangwushuo
 * @time：2022/11/26 17:03
 */
@Service
public class BinanceSpotServiceImpl implements BinanceSpotService {

    private final String apiKey;
    private final String secretKey;
    private final String baseUrl;
    private boolean showLimitUsage = false;

    public BinanceSpotServiceImpl() {
        this.apiKey = null;
        this.secretKey = null;
        this.baseUrl = DefaultUrls.PROD_URL;
    }

    public BinanceSpotServiceImpl(String baseUrl) {
        this.apiKey = null;
        this.secretKey = null;
        this.baseUrl = baseUrl;
    }

    public BinanceSpotServiceImpl(String baseUrl, boolean showLimitUsage) {
        this.apiKey = null;
        this.secretKey = null;
        this.baseUrl = baseUrl;
        this.showLimitUsage = showLimitUsage;
    }

    public BinanceSpotServiceImpl(String apiKey, String secretKey) {
        this.apiKey = apiKey;
        this.secretKey = secretKey;
        this.baseUrl = DefaultUrls.PROD_URL;
    }

    public BinanceSpotServiceImpl(String apiKey, String secretKey, String baseUrl) {
        this.apiKey = apiKey;
        this.secretKey = secretKey;
        this.baseUrl = baseUrl;
    }

    public void setShowLimitUsage(boolean showLimitUsage) {
        this.showLimitUsage = showLimitUsage;
    }

    @Override
    public Blvt createBlvt() {
        return new Blvt(baseUrl, apiKey, secretKey, showLimitUsage);
    }

    @Override
    public BSwap createBswap() {
        return new BSwap(baseUrl, apiKey, secretKey, showLimitUsage);
    }

    @Override
    public C2C createC2C() {
        return new C2C(baseUrl, apiKey, secretKey, showLimitUsage);
    }

    @Override
    public Convert createConvert() {
        return new Convert(baseUrl, apiKey, secretKey, showLimitUsage);
    }

    @Override
    public CryptoLoans createCryptoLoans() {
        return new CryptoLoans(baseUrl, apiKey, secretKey, showLimitUsage); }

    @Override
    public Fiat createFiat() {
        return new Fiat(baseUrl, apiKey, secretKey, showLimitUsage);
    }

    @Override
    public Futures createFutures() {
        return new Futures(baseUrl, apiKey, secretKey, showLimitUsage);
    }

    @Override
    public GiftCard createGiftCard() {
        return new GiftCard(baseUrl, apiKey, secretKey, showLimitUsage); }

    @Override
    public Margin createMargin() {
        return new Margin(baseUrl, apiKey, secretKey, showLimitUsage);
    }

    @Override
    public Market createMarket() {
        return new Market(baseUrl, apiKey, showLimitUsage);
    }

    @Override
    public Mining createMining() {
        return new Mining(baseUrl, apiKey, secretKey, showLimitUsage);
    }

    @Override
    public NFT createNFT() {
        return new NFT(baseUrl, apiKey, secretKey, showLimitUsage);
    }

    @Override
    public Pay createPay() {
        return new Pay(baseUrl, apiKey, secretKey, showLimitUsage);
    }

    @Override
    public PortfolioMargin createPortfolioMargin() {
        return new PortfolioMargin(baseUrl, apiKey, secretKey, showLimitUsage);
    }

    @Override
    public Rebate createRebate() {
        return new Rebate(baseUrl, apiKey, secretKey, showLimitUsage);
    }

    @Override
    public Savings createSavings() {
        return new Savings(baseUrl, apiKey, secretKey, showLimitUsage);
    }

    @Override
    public Staking createStaking() {
        return new Staking(baseUrl, apiKey, secretKey, showLimitUsage);
    }

    @Override
    public SubAccount createSubAccount() {
        return new SubAccount(baseUrl, apiKey, secretKey, showLimitUsage);
    }

    @Override
    public Trade createTrade() {
        return new Trade(baseUrl, apiKey, secretKey, showLimitUsage);
    }

    @Override
    public UserData createUserData() {
        return new UserData(baseUrl, apiKey, showLimitUsage);
    }

    @Override
    public Wallet createWallet() {
        return new Wallet(baseUrl, apiKey, secretKey, showLimitUsage);
    }

}
