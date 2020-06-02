package com.demo.study.gateway.controller;


import com.demo.study.common.exceptions.GlobalException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: 全局异常处理
 * @author: Aaron Ma
 **/
@ControllerAdvice
public class GlobalExceptionHandler {

    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public Map exceptionHandler(Exception ex) {
        Map<String, Object> res = new HashMap<>();
        res.put("ret", 1);
        res.put("errorcode", 500);
        if (ex instanceof MissingServletRequestParameterException) {
            res.put("msg", "缺少必需的参数：" + ((MissingServletRequestParameterException) ex).getParameterName());
        }
        if (ex instanceof GlobalException) {
            res.put("msg", "自定义的异常类");
        }
        return res;
    }
}
