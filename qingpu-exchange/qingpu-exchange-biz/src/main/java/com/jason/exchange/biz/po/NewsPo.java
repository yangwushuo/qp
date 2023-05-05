package com.jason.exchange.biz.po;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author yangwushuo
 * @time 2023/4/29 17:12
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class NewsPo {

    private Integer id;
    private Long admin_id;
    private UserInfoPo userInfoPo;
    private String title;
    private String cover_url;
    private String content;
    private List<Long> likeId;

}
