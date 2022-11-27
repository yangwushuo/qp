package com.jason.binance.biz.bo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author：yangwushuo
 * @time：2022/11/23 16:11
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BinanceKeyBo {

    private String apiKey;

    private String secretKey;

}
