package com.jason.auth.service.impl;

import com.aliyun.sdk.service.dysmsapi20170525.AsyncClient;
import com.aliyun.sdk.service.dysmsapi20170525.models.SendSmsRequest;
import com.aliyun.sdk.service.dysmsapi20170525.models.SendSmsResponse;
import com.aliyun.sdk.service.dysmsapi20170525.models.SendSmsResponseBody;
import com.google.gson.Gson;
import com.jason.auth.config.MailConfig;
import com.jason.auth.service.CaptchaService;
import com.jason.common.util.RandUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * @author：yangwushuo
 * @time：2022/11/5 19:19
 */
@Service
@Slf4j
public class CaptchaServiceImpl implements CaptchaService {

    private final RedisTemplate<String, Object> redisTemplate;

    private final JavaMailSender javaMailSender;

    private final TemplateEngine templateEngine;

    private final MailConfig mailConfig;

    private final AsyncClient asyncClient;

    public CaptchaServiceImpl(RedisTemplate<String, Object> redisTemplate, JavaMailSender javaMailSender, TemplateEngine templateEngine, MailConfig mailConfig, AsyncClient asyncClient) {
        this.redisTemplate = redisTemplate;
        this.javaMailSender = javaMailSender;
        this.templateEngine = templateEngine;
        this.mailConfig = mailConfig;
        this.asyncClient = asyncClient;
    }

    @Override
    public Boolean sendEmailCaptcha(String email) {
        Boolean res = false;
        try {
            //获取MimeMessage对象
            MimeMessage message = javaMailSender.createMimeMessage();
            //是否发送的邮件是富文本（附件，图片，html等）
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(message, true);
            mimeMessageHelper = new MimeMessageHelper(message, true);
            //邮件发送人
            mimeMessageHelper.setFrom(mailConfig.getFromEmail());
            //邮件接收人,设置多个收件人地址
            InternetAddress[] internetAddressTo = InternetAddress.parse(email);
            mimeMessageHelper.setTo(internetAddressTo);
            //messageHelper.setTo(to);
            //邮件主题
            mimeMessageHelper.setSubject("QingPu验证码");
            //使用模板thymeleaf
            //Context是导这个包import org.thymeleaf.context.Context;
            Context context = new Context();
            //定义模板数据
            Map<String,Object> map = new HashMap<>();

            Integer randomNumBySix = RandUtil.randomNumBySix();

            //保存一份到redis缓存中
            redisTemplate.opsForValue().set("captcha".concat(email),randomNumBySix, 3, TimeUnit.MINUTES);

            map.put("captcha", randomNumBySix);
            context.setVariables(map);
            //获取thymeleaf的html模板
            String emailContent = templateEngine.process("/emailCaptcha",context); //指定模板路径
            mimeMessageHelper.setText(emailContent,true);
            //发送邮件
            javaMailSender.send(message);
            log.info("send mail to".concat(email).concat(" success"));
            res = true;
        } catch (Exception e) {
            log.info("send failed to".concat(email).concat(" success"));
            return res;
        }
        return res;
    }

    @Override
    public Boolean sendPhoneCaptcha(String phone) {
        Integer randomNumBySix = RandUtil.randomNumBySix();
        SendSmsRequest sendSmsRequest = SendSmsRequest.builder()
                .signName("阿里云短信测试")
                .templateCode("SMS_154950909")
                .phoneNumbers(phone)
                .templateParam("{\"code\":\"".concat(randomNumBySix.toString()).concat("\"}"))
                // Request-level configuration rewrite, can set Http request parameters, etc.
                // .requestConfiguration(RequestConfiguration.create().setHttpHeaders(new HttpHeaders()))
                .build();
        CompletableFuture<SendSmsResponse> response = asyncClient.sendSms(sendSmsRequest);
        // Synchronously get the return value of the API request
        try {
            SendSmsResponse sendSmsResponse = response.get();
            log.info(new Gson().toJson(sendSmsResponse));
            SendSmsResponseBody body = sendSmsResponse.getBody();
            String code = body.getCode();
            if (code.equals("OK")){
                //保存一份到redis
                redisTemplate.opsForValue().set("captcha".concat(phone),randomNumBySix, 3, TimeUnit.MINUTES);
                return true;
            }else{
                return false;
            }
        }catch (Exception e){
            return false;
        }
    }
}
