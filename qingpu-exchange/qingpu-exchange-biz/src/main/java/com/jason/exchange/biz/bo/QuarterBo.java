package com.jason.exchange.biz.bo;

import lombok.*;

/**
 * @author yangwushuo
 * @time 2023/4/26 22:07
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class QuarterBo {

    private Integer year;
    private String quarter;
    private String details;

}
