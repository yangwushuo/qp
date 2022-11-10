package com.jason.gateway.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author：yangwushuo
 * @time：2022/10/30 19:47
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Accessors(chain = true)
public class IgnoreUrlDto {

    private Long id;

    private String url;

}
