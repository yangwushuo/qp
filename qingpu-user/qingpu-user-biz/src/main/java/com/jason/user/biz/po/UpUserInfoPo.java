package com.jason.user.biz.po;

import lombok.*;

/**
 * @author：yangwushuo
 * @time：2022/11/3 14:57
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class UpUserInfoPo {

    private String username;

    private String email;

    private String portraitImage;

    private String sex;

    private String introduction;

    private Integer province;

    private String birth;

}
