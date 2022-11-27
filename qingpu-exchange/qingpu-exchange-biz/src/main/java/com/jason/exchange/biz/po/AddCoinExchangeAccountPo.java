package com.jason.exchange.biz.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author：yangwushuo
 * @time：2022/11/22 14:09
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddCoinExchangeAccountPo {

    private Long id;

    private String nickName;

    private Long exchangeId;

    private String apiKey;

    private String secretKey;

    private String apiPassword;

    private Boolean verCodeFollow;

    private String verCode;

    private Boolean online;

    private Boolean moneyShow;

    private Boolean tradeHistory;

    private Boolean option;

}
