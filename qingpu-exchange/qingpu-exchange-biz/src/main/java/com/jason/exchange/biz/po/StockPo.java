package com.jason.exchange.biz.po;

import lombok.*;

/**
 * @author yangwushuo
 * @time 2023/5/1 15:53
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class StockPo {

    private Integer id;
    private String symbol;
    private Integer code;

}
