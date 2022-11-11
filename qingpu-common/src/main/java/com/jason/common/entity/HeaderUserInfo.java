package com.jason.common.entity;

import lombok.*;

import java.util.List;

/**
 * @author：yangwushuo
 * @time：2022/11/4 20:21
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class HeaderUserInfo {

    private List<String> aud;

    private String user_name;

    private List<String> scope;

    private Long id;

    private Long exp;

    private List<String> authorities;

    private String jti;

    private String client_id;

}
