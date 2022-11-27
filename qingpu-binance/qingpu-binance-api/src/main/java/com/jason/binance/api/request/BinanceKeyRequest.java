package com.jason.binance.api.request;

import lombok.*;

/**
 * @author：yangwushuo
 * @time：2022/11/23 16:11
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class BinanceKeyRequest {

    private String apiKey;

    private String secretKey;

}
