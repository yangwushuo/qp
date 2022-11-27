package com.jason.exchange.biz.po;

import com.sun.org.apache.xpath.internal.operations.Bool;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author：yangwushuo
 * @time：2022/11/19 22:10
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CoinExchangeAccountPerPo {

    private Long exchangeAccountId;

    private Boolean verCodeFollow;

    private String verCode;

    private Boolean online;

    private Boolean moneyShow;

    private Boolean tradeHistroy;

    private Boolean option;

}
