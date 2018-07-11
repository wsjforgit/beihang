package com.sk.base.exception;


import com.sk.base.commons.Result;
import com.sk.base.commons.ResultState;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 全局异常处理器
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    protected org.slf4j.Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * 拼装验证失败消息
     *
     * @param result 验证信息
     * @return
     */
    private static Map<String, String> getFieldErrorMessage(BindingResult result) {
        Iterator<ObjectError> it = result.getAllErrors().iterator();
        Map<String, String> map = new HashMap<>();
        while (it.hasNext()) {
            FieldError obj = (FieldError) it.next();
            //如果消息为5位数字,则获取infoException中的消息数据显示
            map.put(obj.getField(), obj.getDefaultMessage());
        }
        return map;
    }

    /**
     * 其他异常处理
     *
     * @param e        异常
     * @param response 响应对象
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result exceptionHandler(Exception e, HttpServletResponse response) {
        log.warn("系统异常", e);
        return new Result(ResultState.FAIL, "请联系管理员");

    }

    @ExceptionHandler(value = BusinessException.class)
    @ResponseBody
    public Result exceptionHandler(BusinessException e, HttpServletResponse response) {
        log.warn("业务异常", e.getMessage());
        Result result = new Result(ResultState.FAIL, e.getMessage());
        result.setCode(e.getCode());
        return result;

    }

    /**
     * 请求方法(get,post,delete)异常处理
     *
     * @param e
     * @return
     */
    @ExceptionHandler(value = HttpRequestMethodNotSupportedException.class)
    @ResponseBody
    public Result requestMethodNotSupportedException(HttpRequestMethodNotSupportedException e) {
        log.info("请求方法不允许没有权限访问", e);
        return new Result(ResultState.FAIL, "请求方法不允许没有权限访问");
    }

    /**
     * 数据校验错误处理器
     *
     * @param e
     * @return
     */
    @ExceptionHandler(value = BindException.class)
    @ResponseBody
    public Result bindExceptionHandler(BindException e) {
        BindingResult result = e.getBindingResult();
        if (result.hasErrors()) {
            log.warn("参数绑定异常", e);
            return new Result(ResultState.FAIL, "参数错误", getFieldErrorMessage(result));
        }
        return new Result(ResultState.FAIL);
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    @ResponseBody
    public Result bindExceptionHandler(MethodArgumentNotValidException e) {
        BindingResult result = e.getBindingResult();
        if (result.hasErrors()) {
            log.warn("参数绑定异常", e);
            return new Result(ResultState.FAIL, "参数错误", getFieldErrorMessage(result));
        }
        return new Result(ResultState.FAIL);
    }

    /**
     * 方法参数校验错误处理器
     *
     * @param e
     * @return
     */
    @ExceptionHandler(value = MethodValidationException.class)
    @ResponseBody
    public Result methodValidationExceptionHandler(MethodValidationException e) {
        log.warn("方法参数绑定异常");
        Result result = new Result(ResultState.FAIL, "参数校验失败", e.getResult());
        result.setCode("1001");
        return result;
    }

}
