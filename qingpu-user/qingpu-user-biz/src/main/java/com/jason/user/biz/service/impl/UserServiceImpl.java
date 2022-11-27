package com.jason.user.biz.service.impl;

import com.aventrix.jnanoid.jnanoid.NanoIdUtils;
import com.jason.common.Result.CommonResult;
import com.jason.common.constant.CaptchaSymbol;
import com.jason.common.exception.*;
import com.jason.common.util.RandUtil;
import com.jason.common.util.VerifyUtil;
import com.jason.cs.api.service.CommonServiceRemoteService;
import com.jason.user.biz.bo.*;
import com.jason.user.biz.dao.UserDao;
import com.jason.user.biz.mapstruct.UserMapStruct;
import com.jason.user.biz.po.AddAccountPo;
import com.jason.user.biz.po.FollowPo;
import com.jason.user.biz.po.UpUserInfoPo;
import com.jason.user.biz.po.UserInfoPo;
import com.jason.user.biz.service.OssService;
import com.jason.user.biz.service.UserService;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author：yangwushuo
 * @time：2022/11/1 21:50
 */
@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    private final UserMapStruct userMapStruct;

    private final OssService ossService;

    private final RedisTemplate<String, Object> redisTemplate;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    private final CommonServiceRemoteService commonServiceRemoteService;

    public UserServiceImpl(UserDao userDao, UserMapStruct userMapStruct, OssService ossService, RedisTemplate<String, Object> redisTemplate, BCryptPasswordEncoder bCryptPasswordEncoder, CommonServiceRemoteService commonServiceRemoteService) {
        this.userDao = userDao;
        this.userMapStruct = userMapStruct;
        this.ossService = ossService;
        this.redisTemplate = redisTemplate;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.commonServiceRemoteService = commonServiceRemoteService;
    }

    @Override
    public UserInfoBo getUserInfo(Long id) {
        if (id == null || id < 0){
            throw new GetException("获取失败");
        }

        UserInfoPo userInfoPo = userDao.getUserInfo(id);

        return userMapStruct.userInfoPo2UserInfoBo(userInfoPo);

    }

    @Override
    public void upUserInfo(Long id, UpUserInfoBo upUserInfoBo) {
        //查询是否含有此用户
        Integer userAmount = userDao.getUserAmount(id);
        if (userAmount.equals(1)){
            //Bo to Po
            UpUserInfoPo upUserInfoPo = userMapStruct.upUserInfoBo2UpUserInfoPo(upUserInfoBo);
            userDao.upUserInfo(id, upUserInfoPo);
        }else{
            throw new UpException("更新用户信息失败");
        }

    }

    @Override
    public void upUserPortrait(Long id, MultipartFile file) {
        Integer userAmount = userDao.getUserAmount(id);
        if(userAmount.equals(1)){
            String url = ossService.savePortrait(file);
            if(url == null){
                throw new UpException("更新用户头像失败");
            }
            UpUserInfoBo userInfoBo = UpUserInfoBo.builder()
                    .portraitImage(url)
                    .build();
            try {
                upUserInfo(id, userInfoBo);
            }catch (UpException e){
                throw new UpException("更新用户头像失败");
            }
        }else {
            throw new UpException("更新用户头像失败");
        }

    }

    @Override
    public void addAccount(AddAccountBo addAccountBo) {
        if (addAccountBo.getSymbol() == null ||
        addAccountBo.getCaptcha() == null ||
        addAccountBo.getContent() == null ||
        addAccountBo.getPassword() == null){
            throw new AddException("创建账户失败");
        }

        if(addAccountBo.getSymbol().equals(1)){
            //校验是否是手机号
            Boolean verRes = VerifyUtil.verifyChinaPhoneNum(addAccountBo.getContent());
            if (verRes){
                String captchaValue = getValueByKey(CaptchaSymbol.addAccountCaptchaSymbol.toString().concat("captcha").concat(addAccountBo.getContent()));
                if (captchaValue.equalsIgnoreCase(addAccountBo.getCaptcha())){
                    Boolean addRes = addAccountToDB(addAccountBo);
                    if (!addRes){
                        throw new AddException("创建账户失败");
                    }else{
                        //创建账户成功删除键值对
                        redisTemplate.delete(captchaValue);
                    }
                }else{
                    throw new AddException("创建账户失败");
                }
            }else{
                throw new AddException("创建账户失败");
            }
        }else if (addAccountBo.getSymbol().equals(2)){
            //校验邮箱
            Boolean verRes = VerifyUtil.verifyEmail(addAccountBo.getContent());
            if (verRes){
                String captchaValue = getValueByKey(CaptchaSymbol.addAccountCaptchaSymbol.toString().concat("captcha").concat(addAccountBo.getContent()));
                if (captchaValue.equalsIgnoreCase(addAccountBo.getCaptcha())){
                    Boolean addRes = addAccountToDB(addAccountBo);
                    if (!addRes){
                        throw new AddException("创建账户失败");
                    }else{
                        //创建账户成功删除键值对
                        redisTemplate.delete(captchaValue);
                    }
                }else{
                    throw new AddException("创建账户失败");
                }
            }else{
                throw new AddException("创建账户失败");
            }
        }else{
            throw new AddException("创建账户失败");
        }

    }

    @Override
    public void addFollow(Long uid, Long fid) {

        if (uid == null || uid <= 0 || fid == null || fid <= 0){
            throw new AddException("关注失败");
        }

        //查询是否有此用户可关注
        Integer userAmount = userDao.getUserAmount(fid);
        if (!userAmount.equals(1)){
            throw new AddException("关注失败");
        }

        //查询是否已经关注
        List<FollowPo> followPos = userDao.getFollowUserById(uid, fid);
        System.out.println(followPos);
        if(followPos.size() != 0){
            throw new AddException("关注失败");
        }

        //创建关注时间
        Long followTime = System.currentTimeMillis();
        userDao.addFollow(uid, fid, followTime);

    }

    @Override
    public List<FollowBo> getFollow(Long uid) {

        if(uid == null || uid <= 0){
            throw new GetException("获取关注信息失败");
        }

        //查询关注列表
        List<FollowPo> followPos = userDao.getFollowUserById(uid, null);
        List<FollowBo> followBos = userMapStruct.followPoList2FollowBoList(followPos);
        return followBos;

    }

    @Override
    public void cancelFollow(Long uid, Long fid) {

        if (uid == null || uid <= 0 || fid == null || fid <= 0){
            throw new DelException("取消失败");
        }

        userDao.delFollow(uid, fid);

    }

    @Override
    public void upPhone(Long uid, UpPhoneAndEmailBo upPhoneAndEmailBo) {
        System.out.println(upPhoneAndEmailBo);
        if(
                upPhoneAndEmailBo.getPhone() == null || upPhoneAndEmailBo.getPhone().length() <= 0 || !VerifyUtil.verifyChinaPhoneNum(upPhoneAndEmailBo.getPhone()) ||
                upPhoneAndEmailBo.getCaptcha() == null || upPhoneAndEmailBo.getCaptcha().length() <= 0 ||
                upPhoneAndEmailBo.getCaptchaKey() == null || upPhoneAndEmailBo.getCaptchaKey().length() <= 0
        ){
            throw new UpException("新手机号错误,更新失败");
        }

        String key = upPhoneAndEmailBo.getCaptchaKey();
        String captchaValue = getValueByKey(key);
        if(!captchaValue.equalsIgnoreCase(upPhoneAndEmailBo.getCaptcha())){
            throw new UpException("验证码错误,更新失败");
        }else{
            //比对成功清空键值对
            redisTemplate.delete(key);
        }

        userDao.upPhone(uid, upPhoneAndEmailBo.getPhone());

    }

    @Override
    public void upEmail(Long uid, UpPhoneAndEmailBo upPhoneAndEmailBo) {
        if(
                upPhoneAndEmailBo.getEmail() == null || upPhoneAndEmailBo.getEmail().length() <= 0 || !VerifyUtil.verifyEmail(upPhoneAndEmailBo.getEmail()) ||
                upPhoneAndEmailBo.getCaptcha() == null || upPhoneAndEmailBo.getCaptcha().length() <= 0 ||
                upPhoneAndEmailBo.getCaptchaKey() == null || upPhoneAndEmailBo.getCaptchaKey().length() <= 0
        ){
            throw new UpException("新邮箱错误,更新失败");
        }

        String key = upPhoneAndEmailBo.getCaptchaKey();
        String captchaValue = getValueByKey(key);
        if(!captchaValue.equalsIgnoreCase(upPhoneAndEmailBo.getCaptcha())){
            throw new UpException("验证码错误,更新失败");
        }else{
            //比对成功清空键值对
            redisTemplate.delete(key);
        }

        userDao.upEmail(uid, upPhoneAndEmailBo.getEmail());
    }

    @Override
    public String sendCaptcha2Phone(Long uid) {

        String userPhone = userDao.getUserPhoneById(uid);
        if (userPhone == null || userPhone.length() <= 0){
            throw new GetException("请先绑定手机");
        }

        Integer randomNumBySix = RandUtil.randomNumBySix();
        CommonResult<String> sendRes = commonServiceRemoteService.sendPhoneCaptcha(userPhone, randomNumBySix.toString());
        if (sendRes.getCode() == 200){
            //保存一份到redis
            String key = NanoIdUtils.randomNanoId();
            redisTemplate.opsForValue().set(key, randomNumBySix, 3, TimeUnit.MINUTES);
            return key;
        }else{
            throw new GetException("发送失败");
        }

    }

    @Override
    public String sendCaptcha2Email(Long uid) {

        String userEmail = userDao.getUserEmailById(uid);
        if (userEmail == null || userEmail.length() <= 0){
            throw new GetException("请先绑定邮箱");
        }

        Integer randomNumBySix = RandUtil.randomNumBySix();
        CommonResult<String> sendRes = commonServiceRemoteService.sendEmailCaptcha(userEmail, randomNumBySix.toString());
        if (sendRes.getCode() == 200){
            //保存一份到redis
            String key = NanoIdUtils.randomNanoId();
            redisTemplate.opsForValue().set(key, randomNumBySix, 3, TimeUnit.MINUTES);
            return key;
        }else{
            throw new GetException("发送失败");
        }

    }

    @Override
    public void verPassword(Long uid, VerPwdBo verPwdBo) {

        if (uid == null || uid <= 0 || verPwdBo.getPassword() == null || verPwdBo.getPassword().length() <= 0){
            throw new VerException("校验失败,参数错误");
        }

        //获取用户密码
        String userPassword = userDao.getUserPasswordById(uid);
        //比对
        boolean matcheRes = bCryptPasswordEncoder.matches(verPwdBo.getPassword(), userPassword);
        if (!matcheRes){
            throw  new VerException("校验失败");
        }

    }

    //获取value
    private String getValueByKey(String key){
        return String.valueOf(redisTemplate.opsForValue().get(key));
    }

    private Boolean  addAccountToDB(AddAccountBo addAccountBo){
        //校验成功创建账户
        AddAccountPo addAccountPo = userMapStruct.addAccountBo2AddAccountPo(addAccountBo);
        addAccountPo.setUsername(NanoIdUtils.randomNanoId());
        addAccountPo.setPassword(bCryptPasswordEncoder.encode(addAccountPo.getPassword()));
        addAccountPo.setCreateTime(System.currentTimeMillis());
        //随机头像
        String portraitUrl = "https://qing-pu.oss-cn-hangzhou.aliyuncs.com/portrait/portrait_".concat(RandUtil.randomNumByMinAndMax(1,20).toString()).concat(".JPEG");
        addAccountPo.setPortraitImage(portraitUrl);
        //校验成功创建账户
        userDao.addAccount(addAccountPo);
        if(addAccountPo.getId() != null){
            //添加用户信息
            userDao.addAccountInfo(addAccountPo);
            //为用户创建角色
            Long adminId = userDao.getRoleIdByName("ADMIN");
            userDao.addRole(addAccountPo.getId(), adminId);
            return true;
        }
        return false;
    }

}
