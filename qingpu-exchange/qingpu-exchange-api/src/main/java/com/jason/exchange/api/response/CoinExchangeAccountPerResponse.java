package com.jason.exchange.api.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
@ApiModel(value = "交易账户权限信息", description = "交易账户权限信息描述")
public class CoinExchangeAccountPerResponse {

    @ApiModelProperty("交易账户id")
    private Long exchangeAccountId;

    @ApiModelProperty("开启订阅码")
    private Boolean verCodeFollow;

    @ApiModelProperty("订阅码")
    private String verCode;

    @ApiModelProperty("开启线上公开")
    private Boolean online;

    @ApiModelProperty("开启资金展示")
    private Boolean moneyShow;

    @ApiModelProperty("开启交易历史")
    private Boolean tradeHistroy;

    @ApiModelProperty("开启持仓")
    private Boolean option;

}
