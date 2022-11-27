package com.jason.exchange.biz.po;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author：yangwushuo
 * @time：2022/11/21 14:21
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "更新交易所账户信息", description = "更新交易所账户信息描述")
public class UpCoinExchangeAccountPo {

    private Long exchangeAccountId;

    private String nickName;

    private Boolean verCodeFollow;

    private String verCode;

    private Boolean online;

    private Boolean moneyShow;

    private Boolean tradeHistory;

    private Boolean option;

}
