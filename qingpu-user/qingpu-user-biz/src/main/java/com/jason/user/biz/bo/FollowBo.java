package com.jason.user.biz.bo;

import lombok.*;

/**
 * @author：yangwushuo
 * @time：2022/11/9 16:04
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class FollowBo {

    private Long id;

    private Long followUserId;

    private String username;

    private String  introduction;

    private String portraitImage;

    private Long followTime;

}
