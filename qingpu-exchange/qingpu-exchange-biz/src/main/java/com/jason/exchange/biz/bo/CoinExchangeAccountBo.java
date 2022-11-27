package com.jason.exchange.biz.bo;

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
public class CoinExchangeAccountBo {

    private Long id;

    private Long userId;

    private CoinExchangeBo coinExchangeBo;

    private CoinExchangeAccountPerBo coinExchangeAccountPerBo;

    private Long createTime;

    private String apiKey;

    private String secretKey;

    private String apiPassword;

    private Integer usageAccount;

    private Long latestUseTime;

    private String nickName;

}
