package com.sk.base.exception;

import java.util.Map;

/**
 * Created by WangYajie on 2016/11/18.
 * 方法验证异常
 */
public class MethodValidationException extends RuntimeException {
    private final Map<String, String> result;

    /**
     * 方法验证异常信息
     *
     * @param result 返回的验证异常信息
     */
    public MethodValidationException(Map<String, String> result) {
        this.result = result;
    }

    public Map<String, String> getResult() {
        return result;
    }
}
