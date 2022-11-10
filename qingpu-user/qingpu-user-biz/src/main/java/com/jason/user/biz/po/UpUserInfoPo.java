package com.jason.user.biz.bo;

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
public class UpUserInfoBo {

    private Long id;

    private String username;

    private String email;

    private String sex;

    private String introduction;

    private Integer province;

    private String birth;

}
