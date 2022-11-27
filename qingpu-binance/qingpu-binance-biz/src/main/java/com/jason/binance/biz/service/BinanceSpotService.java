package com.jason.binance.biz.service;

import com.jason.binance.biz.service.impl.spot.*;

/**
 * @author：yangwushuo
 * @time：2022/11/26 17:03
 */
public interface BinanceSpotService {

    Blvt createBlvt();
    BSwap createBswap();
    C2C createC2C();
    Convert createConvert();
    CryptoLoans createCryptoLoans();
    Fiat createFiat();
    Futures createFutures();
    GiftCard createGiftCard();
    Market createMarket();
    Margin createMargin();
    Mining createMining();
    NFT createNFT();
    Pay createPay();
    PortfolioMargin createPortfolioMargin();
    Rebate createRebate();
    Savings createSavings();
    Staking createStaking();
    SubAccount createSubAccount();
    Trade createTrade();
    UserData createUserData();
    Wallet createWallet();

}
