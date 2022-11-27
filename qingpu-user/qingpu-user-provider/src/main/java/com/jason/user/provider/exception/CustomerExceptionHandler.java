package com.jason.user.provider.exception;


import com.jason.common.Result.CommonResult;
import com.jason.common.exception.*;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * 处理全局异常
 * @author: yangwushuo
 * @time: 2022/11/17 21:05
 */
@ControllerAdvice
public class CustomerExceptionHandler {

  @ResponseBody
  @ExceptionHandler(value = {
          AddException.class,
          UpException.class,
          GetException.class,
          DelException.class,
          VerException.class
  })
  public CommonResult<String> handerException(Exception e) {
    return CommonResult.failed(e.getMessage());
  }

}
