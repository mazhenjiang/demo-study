package com.demo.study.common.data;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.util.StringUtils;

/**
 * @description:
 * @author: Aaron Ma
 **/
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Result<T> {
    private Integer ret;
    private T data;
    private Integer errorcode;
    private String msg;

    public Result(T data) {
        this.ret = 200;
        this.data = data;
        this.errorcode = 0;
        this.msg = "success";
    }

    public Result() {
        this(null);
    }

    public static Result<Void> success() {
        return new Result<Void>();
    }

    public static <Ts> Result<Ts> success(Ts data) {
        return new Result<Ts>(data);
    }

    public static <Tf> Result<Tf> fail(int errorcode, String msg, Tf data) {
        if (errorcode == 0) {
            throw new IllegalArgumentException("errorcode can't be 0");
        }
        Result<Tf> result = new Result<>();
        result.setData(data);
        result.setErrorcode(errorcode);
        if (StringUtils.hasLength(msg)) {
            result.setMsg(msg);
        } else {
            result.setMsg("fail");
        }
        result.setRet(1);
        return result;
    }

    public Integer getRet() {
        return ret;
    }

    public void setRet(Integer ret) {
        this.ret = ret;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Integer getErrorcode() {
        return errorcode;
    }

    public void setErrorcode(Integer errorcode) {
        this.errorcode = errorcode;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
