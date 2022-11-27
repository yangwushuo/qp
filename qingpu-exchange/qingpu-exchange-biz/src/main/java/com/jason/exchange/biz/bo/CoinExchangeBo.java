package com.jason.exchange.biz.bo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author：yangwushuo
 * @time：2022/11/17 18:38
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CoinExchangeBo {

    private Long id;

    private String name;

    private Boolean spot;

    private Boolean usdFuture;

    private Boolean coinFuture;

    private Boolean option;

}
