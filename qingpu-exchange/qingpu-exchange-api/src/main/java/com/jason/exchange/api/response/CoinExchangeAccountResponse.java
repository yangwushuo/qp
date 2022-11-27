package com.jason.exchange.api.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author：yangwushuo
 * @time：2022/11/19 15:45
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "交易账户信息", description = "交易账户信息描述")
public class CoinExchangeAccountResponse {

    @ApiModelProperty("id")
    private Long id;

    @ApiModelProperty("用户id")
    private Long userId;

    @ApiModelProperty("交易所信息")
    private CoinExchangeResponse coinExchangeResponse;

    @ApiModelProperty("交易账户权限信息")
    private CoinExchangeAccountPerResponse coinExchangeAccountPerResponse;

    @ApiModelProperty("创户时间")
    private Long createTime;

    @ApiModelProperty("账户使用次数")
    private Integer usageAccount;

    @ApiModelProperty("最新使用时间")
    private Long latestUseTime;

    @ApiModelProperty("昵称")
    private String nickName;

}
