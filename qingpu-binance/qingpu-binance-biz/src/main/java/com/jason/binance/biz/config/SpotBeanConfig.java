package com.jason.binance.biz.config;

import com.jason.binance.biz.service.BinanceSpotService;
import com.jason.binance.biz.service.impl.spot.Trade;
import com.jason.binance.biz.service.impl.spot.Wallet;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author：yangwushuo
 * @time：2022/11/28 9:02
 */
@Configuration
public class SpotBeanConfig {

    private final BinanceSpotService binanceSpotService;

    public SpotBeanConfig(BinanceSpotService binanceSpotService) {
        this.binanceSpotService = binanceSpotService;
    }

    @Bean
    Trade spotTrade(){
        return binanceSpotService.createTrade();
    }

    @Bean
    Wallet spotWallet(){
        return binanceSpotService.createWallet();
    }


}
