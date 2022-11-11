package com.jason.user.biz.po;

import lombok.*;

/**
 * @author：yangwushuo
 * @time：2022/11/6 14:56
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class AddAccountPo {

    private Long id;

    private Integer symbol;

    private String portraitImage;

    private String content;

    private String username;

    private Long createTime;

    private String password;

    private String captcha;

    private Long timestamp;

}
