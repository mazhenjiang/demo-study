package com.demo.study.common.exceptions;

import com.demo.study.common.data.Result;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description: 全局异常类
 * @author: Aaron Ma
 **/
@Data
public class GlobalException extends RuntimeException {

    private Integer ret;
    private Integer errorcode;
    private String msg;

}
