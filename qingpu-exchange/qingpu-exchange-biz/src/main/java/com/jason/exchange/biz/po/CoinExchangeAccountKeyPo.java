package com.jason.exchange.biz.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author：yangwushuo
 * @time：2022/11/22 14:57
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CoinExchangeAccountKeyPo {

    private Long id;

    private String apiKey;

    private String secretKey;

    private String apiPassword;

}
