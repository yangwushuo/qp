package com.jason.binance.biz.config;

import com.jason.binance.biz.service.BinanceSpotService;
import com.jason.binance.biz.service.impl.spot.Market;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author：yangwushuo
 * @time：2022/12/1 10:17
 */
@Configuration
public class MarketBeanConfig {

    private final BinanceSpotService binanceSpotService;

    public MarketBeanConfig(BinanceSpotService binanceSpotService) {
        this.binanceSpotService = binanceSpotService;
    }

    @Bean
    Market spotMarket(){
        return binanceSpotService.createMarket();
    }


}
