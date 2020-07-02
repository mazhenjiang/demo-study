package com.demo.study.common.exceptions;

/**
 * @description: UnCheckBusinessException
 * @author: Aaron Ma
 **/
public class BusinessRuntimeException extends RuntimeException{

    public BusinessRuntimeException(String s) {
        super(s);
    }
}
