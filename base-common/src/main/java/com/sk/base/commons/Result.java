package com.sk.base.commons;

import lombok.Data;
import org.apache.commons.lang3.time.DateFormatUtils;

import java.util.Date;

/**
 * Created by YajieWang on 2016/8/5.
 */
@Data
public class Result {
    ResultState state = ResultState.SUCCESS;
    String message;
    String code;
    Object data;
    String timestamp = DateFormatUtils.format(new Date(), "yyyyMMddHHmmss");

    public Result(ResultState state, String message, Object data) {
        this.state = state;
        this.message = message;
        this.data = data;
    }

    public Result(ResultState state, String message, String code) {
        this.state = state;
        this.message = message;
        this.code = code;
    }


    public Result(ResultState state, String message) {
        this.state = state;
        this.message = message;
    }

    public Result(Object data) {
        this.state = ResultState.SUCCESS;
        this.data = data;
    }

    public String getCode() {
        if (this.state == ResultState.SUCCESS) {
            return "0";
        }
        if (!"0".equals(this.code)) {
            return this.code;
        }
        return "-1";
    }

    public void setState(ResultState state) {
        this.state = state;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}
