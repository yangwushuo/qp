package com.jason.exchange.api.request;

import io.swagger.annotations.ApiModel;
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
@ApiModel(value = "添加交易所账户信息", description = "添加交易所账户信息描述")
public class AddCoinExchangeAccountRequest {

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
