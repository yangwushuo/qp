package com.jason.auth.domain.po;

import lombok.*;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * @author：yangwushuo
 * @time：2022/10/29 21:00
 */
@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
@Accessors(chain = true)
public class ClientPo {

    private String clientId;

    private String resourceIds;

    private String clientSecret;

    private String scope;

    private String authorizedGrantTypes;

    private String authorities;

    private String webServerRedirectUri;

    private Integer accessTokenValidity;

    private Integer refreshTokenValidity;

    private String additionalInformation;

    private String autoapprove;

    private Boolean secretRequire;

    private Boolean scopeRequire;

}
