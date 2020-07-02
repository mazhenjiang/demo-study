package com.demo.study.gateway.controller;

import com.demo.study.common.exceptions.GlobalRuntimeException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description: 测试全局异常类处理
 * @author: Aaron Ma
 **/
@RestController
public class TestGlobalExceptionHandler {

    @RequestMapping("/test_exception")
    public String testException() throws Exception{
        throw new MissingServletRequestParameterException("name","String");
    }

    @RequestMapping("/test_global_exception")
    public String testGlobalException() throws Exception{
        throw new GlobalRuntimeException();
    }
}
