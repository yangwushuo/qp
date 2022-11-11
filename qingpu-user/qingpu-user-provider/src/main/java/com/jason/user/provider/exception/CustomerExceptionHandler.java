package com.jason.user.provider.exception;


import com.jason.common.Result.CommonResult;
import com.jason.common.exception.AddException;
import com.jason.common.exception.DelException;
import com.jason.common.exception.GetException;
import com.jason.common.exception.UpException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * 全局处理Oauth2抛出的异常
 *
 * @author Honghui [wanghonghui_work@163.com] 2021/3/16
 */
@ControllerAdvice
public class CustomerExceptionHandler {

  @ResponseBody
  @ExceptionHandler(value = {
          AddException.class,
          UpException.class,
          GetException.class,
          DelException.class
  })
  public CommonResult<String> handerException(Exception e) {
    return CommonResult.failed(e.getMessage());
  }

}
