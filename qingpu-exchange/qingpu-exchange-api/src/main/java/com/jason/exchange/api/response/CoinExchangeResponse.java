package com.jason.exchange.api.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author：yangwushuo
 * @time：2022/11/17 19:18
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "交易所信息", description = "交易所信息描述")
public class CoinExchangeResponse {

    @ApiModelProperty("id")
    private Long id;

    @ApiModelProperty("交易所名")
    private String name;

    @ApiModelProperty("现货")
    private Boolean spot;

    @ApiModelProperty("U本位")
    private Boolean usdFuture;

    @ApiModelProperty("币本位")
    private Boolean coinFuture;

    @ApiModelProperty("期货")
    private Boolean option;

}
