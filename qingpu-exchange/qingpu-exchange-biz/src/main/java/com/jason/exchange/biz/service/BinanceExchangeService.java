package com.jason.exchange.biz.service;

/**
 * @author：yangwushuo
 * @time：2022/12/1 10:42
 */
public interface BinanceExchangeService {

    Object getBinanceSpotAccountInfo(Long userId, Long exAccId);

    Object getBinanceSpotOrders(Long userId, Long exAccId, String symbol, Long orderId, Long startTime, Long endTime, Integer limit);

    Object getBinanceSpotOpenOrders(Long userId, Long exAccId, String symbol);

    Object getBinanceSpotOcoOrders(Long userId, Long exAccId, Long fromId, Long startTime, Long endTime, Integer limit);

    Object getBinanceSpotOpenOcoOrders(Long userId, Long exAccId);

    Object getBinanceSpotTrades(Long userId, Long exAccId, String symbol, Long orderId, Long startTime, Long endTime, Long fromId, Integer limit);

    Object getBinanceSpotRateLimitOrder(Long userId, Long exAccId);

    Object binanceMarketPing();

}
