package com.jason.exchange.biz.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author yangwushuo
 * @time 2023/4/27 21:41
 */
public interface OssService {

    /**
     * @return a
     * @Author yangwushuo
     * @Decription //TODO 保存用户头像
     * @Date 19:25 2022/11/4
     * @Param
     **/
    String savePortrait(MultipartFile file);



}
