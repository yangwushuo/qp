package com.jason.exchange.biz.bo;

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
public class CoinExchangeAccountPerBo {

    private Long exchangeAccountId;

    private Boolean verCodeFollow;

    private String verCode;

    private Boolean online;

    private Boolean moneyShow;

    private Boolean tradeHistroy;

    private Boolean option;

}
