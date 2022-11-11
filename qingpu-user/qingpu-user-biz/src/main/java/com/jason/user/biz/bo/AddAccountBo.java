package com.jason.user.biz.bo;

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
public class AddAccountBo {

    private Integer symbol;

    private String content;

    private String password;

    private String captcha;

    private Long timestamp;

}
