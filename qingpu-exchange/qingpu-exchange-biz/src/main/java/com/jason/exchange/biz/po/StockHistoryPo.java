package com.jason.exchange.biz.po;

import lombok.*;

import java.math.BigDecimal;

/**
 * @author yangwushuo
 * @time 2023/5/2 10:22
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class StockHistoryPo {

    private String day;
    private String open;
    private String high;
    private String low;
    private String close;
    private String volume;

}
