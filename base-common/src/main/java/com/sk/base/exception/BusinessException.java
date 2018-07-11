package com.sk.base.exception;

/**
 * Created by WangYajie on 2016/9/13.
 * 业务异常
 */
public class BusinessException extends RuntimeException {
    private String code;


    public BusinessException(String message, String code) {
        super(message);
        this.code = code;
    }

    public BusinessException() {

    }

    public BusinessException(String message) {
        super(message);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
