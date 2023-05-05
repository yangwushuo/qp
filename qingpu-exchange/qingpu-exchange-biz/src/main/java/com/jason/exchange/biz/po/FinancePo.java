package com.jason.exchange.biz.po;

import lombok.*;

/**
 * @author yangwushuo
 * @time 2023/4/27 22:37
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class FinancePo {

    private Integer id;
    private String title;
    private Integer quarter_id;
    private String file_url;

}
