package com.jason.cs.biz.service.impl;

import com.aliyun.sdk.service.dysmsapi20170525.AsyncClient;
import com.aliyun.sdk.service.dysmsapi20170525.models.SendSmsRequest;
import com.aliyun.sdk.service.dysmsapi20170525.models.SendSmsResponse;
import com.aliyun.sdk.service.dysmsapi20170525.models.SendSmsResponseBody;
import com.google.gson.Gson;
import com.jason.common.constant.CaptchaSymbol;
import com.jason.common.exception.GetException;
import com.jason.common.util.RandUtil;
import com.jason.common.util.VerifyUtil;
import com.jason.cs.biz.config.MailConfig;
import com.jason.cs.biz.service.CaptchaService;
import lombok.extern.slf4j.Slf4j;
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



/**
 * @author yangwushuo
 * @time 2022/11/13 19:50
 */
@Service
@Slf4j
public class CaptchaServiceImpl implements CaptchaService {

    private final JavaMailSender javaMailSender;

    private final TemplateEngine templateEngine;

    private final MailConfig mailConfig;

    private final AsyncClient asyncClient;

    public CaptchaServiceImpl(JavaMailSender javaMailSender, TemplateEngine templateEngine, MailConfig mailConfig, AsyncClient asyncClient) {
        this.javaMailSender = javaMailSender;
        this.templateEngine = templateEngine;
        this.mailConfig = mailConfig;
        this.asyncClient = asyncClient;
    }


    @Override
    public void sendPhoneCaptcha(String phone, String captcha) {

        if (phone == null || phone.length() <=0 || !VerifyUtil.verifyChinaPhoneNum(phone)){
            throw new GetException("参数问题,发送失败");
        }

        SendSmsRequest sendSmsRequest = SendSmsRequest.builder()
                .signName("阿里云短信测试")
                .templateCode("SMS_154950909")
                .phoneNumbers(phone)
                .templateParam("{\"code\":\"".concat(captcha).concat("\"}"))
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

            }else{
                throw new GetException("发送失败");
            }
        }catch (Exception e){
            throw new GetException("发送失败");
        }
    }

    @Override
    public void sendEmailCaptcha(String email, String captcha) {
        if (email == null || email.length() <=0 || !VerifyUtil.verifyEmail(email)){
            throw new GetException("参数问题,发送失败");
        }

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

            map.put("captcha", captcha);
            context.setVariables(map);
            //获取thymeleaf的html模板
            String emailContent = templateEngine.process("/emailCaptcha",context); //指定模板路径
            mimeMessageHelper.setText(emailContent,true);
            //发送邮件
            javaMailSender.send(message);
            log.info("send mail to".concat(email).concat(" success"));
        } catch (Exception e) {
            log.info("send failed to".concat(email).concat(" success"));
            throw new GetException("发送失败");
        }
    }

}
