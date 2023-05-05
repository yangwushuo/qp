package com.jason.exchange.biz.po;

import lombok.*;

import java.util.List;

/**
 * @author yangwushuo
 * @time 2023/4/26 22:07
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class QuarterPo {

    private Integer id;
    private Integer year;
    private String quarter;
    private String details;
    List<FinancePo> financePos;

}
