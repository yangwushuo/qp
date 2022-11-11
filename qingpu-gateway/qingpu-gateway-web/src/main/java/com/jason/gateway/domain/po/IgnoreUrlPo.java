package com.jason.gateway.domain.po;

import lombok.*;
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
public class IgnoreUrlPo {

    private Long id;

    private String url;

}
