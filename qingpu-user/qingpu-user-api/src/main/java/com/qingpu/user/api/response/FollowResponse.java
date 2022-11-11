package com.qingpu.user.api.response;

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
public class FollowResponse {

    private Long id;

    private Long followUserId;

    private String username;

    private String  introduction;

    private String portraitImage;

    private Long followTime;

}
