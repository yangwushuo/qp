package com.jason.exchange.api.request;

import io.swagger.annotations.ApiModel;
import lombok.*;

/**
 * @author yangwushuo
 * @time 2023/4/26 21:58
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@ApiModel(value = "财报信息", description = "")
public class QuarterRequest {
    private Integer year;
    private String quarter;
    private String details;
}
