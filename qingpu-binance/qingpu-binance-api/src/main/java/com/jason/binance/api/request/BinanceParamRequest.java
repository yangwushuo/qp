package com.jason.binance.api.request;

import lombok.*;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author：yangwushuo
 * @time：2022/11/23 16:11
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class BinanceParamRequest {

    private String apiKey;

    private String secretKey;

    private LinkedHashMap<String,Object> params;

}
