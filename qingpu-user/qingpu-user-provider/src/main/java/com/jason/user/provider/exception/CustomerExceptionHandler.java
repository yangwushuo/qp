package com.jason.user.provider.exception;


import com.jason.common.Result.CommonResult;
import org.springframework.security.oauth2.common.exceptions.OAuth2Exception;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * 全局处理Oauth2抛出的异常
 *
 * @author Honghui [wanghonghui_work@163.com] 2021/3/16
 */
@ControllerAdvice
public class CExceptionHandler {

  @ResponseBody
  @ExceptionHandler(value = OAuth2Exception.class)
  public CommonResult<String> handleOauth2(OAuth2Exception e) {
    return CommonResult.failed(e.getMessage());
  }

  @ResponseBody
  @ExceptionHandler(value = CaptchaException.class)
  public CommonResult<String> handleCaptcha(CaptchaException e){
    return CommonResult.failed(e.getMessage());
  }

}
