package com.demo.study.gateway.controller;


import com.demo.study.common.data.Result;
import com.demo.study.common.exceptions.BusinessRuntimeException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @description: 全局异常处理
 * @author: Aaron Ma
 **/
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {


    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public Result<String> handlerException(Exception ex) {

        log.error("未知异常！原因是:",ex.getMessage(), ex);
        return Result.fail(500, ex.getMessage(), null);
    }

    /**
     * 业务异常
     *
     * @param ex
     * @return
     */
    @ResponseBody
    @ExceptionHandler(value = BusinessRuntimeException.class)
    public Result<String> handlerBizException(BusinessRuntimeException ex) {

        log.error("发生业务异常！原因是：{}", ex.getMessage());
        return Result.fail(500, ex.getMessage(), null);
    }

    /**
     * 处理空指针的异常
     */
    @ResponseBody
    @ExceptionHandler(value = NullPointerException.class)
    public Result<Void> exceptionHandler(NullPointerException e) {
        log.error("发生空指针异常！原因是:", e.getMessage(), e);
        return Result.fail(500, e.getMessage(), null);
    }
}
