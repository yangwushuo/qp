package com.jason.user.biz.service;

import com.jason.user.biz.bo.AddAccountBo;
import com.jason.user.biz.bo.FollowBo;
import com.jason.user.biz.bo.UpUserInfoBo;
import com.jason.user.biz.bo.UserInfoBo;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author：yangwushuo
 * @time：2022/11/1 21:50
 */
public interface UserService {

    UserInfoBo getUserInfo(Long id);

    void upUserInfo(Long id, UpUserInfoBo userInfoBo);

    void upUserPortrait(Long id, MultipartFile file);

    void addAccount(AddAccountBo addAccountBo);

    void addFollow(Long uid, Long fid);

    List<FollowBo> getFollow(Long uid);

    void cancelFollow(Long uid, Long fid);

    void upPhone(Long uid, String phone, String captcha);

    void upEmail(Long uid, String email, String captcha);

    void sendCaptcha2Phone(Long uid, Integer symbol);

    void sendCaptcha2Email(Long uid, Integer symbol);

}
