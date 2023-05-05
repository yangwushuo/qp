package com.jason.exchange.biz.po;

import lombok.*;

/**
 * @author yangwushuo
 * @time 2023/4/29 13:53
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class FavoriteFilesPo {

    private Integer id;
    private Long user_id;
    private Integer financial_report_id;

}
