package com.jason.cs.provider.exception;

import com.jason.common.Result.CommonResult;
import com.jason.common.exception.GetException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author yangwushuo
 * @time 2022/11/13 19:41
 */
@ControllerAdvice
public class CostomExceptionHandler {

    @ResponseBody
    @ExceptionHandler(value = GetException.class)
    public CommonResult<String> handleCaptcha(GetException e){
        return CommonResult.failed(e.getMessage());
    }

}
