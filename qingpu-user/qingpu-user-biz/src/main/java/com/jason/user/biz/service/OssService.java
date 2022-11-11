package com.jason.user.biz.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;

/**
 * @author：yangwushuo
 * @time：2022/11/4 19:16
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
