package com.sk.base.commons;


import com.sk.base.exception.MethodValidationException;
import org.apache.commons.collections.CollectionUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.DefaultParameterNameDiscoverer;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;
import javax.validation.executable.ExecutableValidator;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by YajieWang on 2016/5/9.
 * 处理方法参数校验
 */
@Component
@Aspect
public class MethodValidation {
    protected Logger log = LoggerFactory.getLogger(MethodValidation.class);
    private final static ValidatorFactory factory = Validation.buildDefaultValidatorFactory();

    /**
     * 处理 方法校验异常
     *
     * @param joinPoint 连接点悉信息
     * @return 方法执行结果 com.sk.p2p.camera.controller;
     * @throws Throwable
     */
    @Around("execution(* com.sk.*.*.controller.*.*(..))")
    public <T> Object processException(ProceedingJoinPoint joinPoint) throws Throwable {
        Method method = ((MethodSignature) joinPoint.getSignature()).getMethod();
        // 获取校验器
        ExecutableValidator executableValidator = factory.getValidator().forExecutables();
        //校验T
        Set<ConstraintViolation<T>> violations =
                executableValidator.validateParameters((T) joinPoint.getTarget(), method, joinPoint.getArgs());
        if (CollectionUtils.isNotEmpty(violations)) {
            //参数名转换
            DefaultParameterNameDiscoverer discoverer = new DefaultParameterNameDiscoverer();
            String[] parameterNames = discoverer.getParameterNames(method);
            Parameter[] parameters = method.getParameters();
            Map<String, String> map = new HashMap<>();
            for (int i = 0; i < parameterNames.length; i++) {
                map.put(parameters[i].getName(), parameterNames[i]);
            }
            //校验结果
            Map<String, String> result = new HashMap<>();
            for (ConstraintViolation<T> violation : violations) {
                String path = violation.getPropertyPath().toString();
                String arg = path.substring(path.lastIndexOf('.') + 1);
//                result.put(map.get(arg) + "_" + violation.getConstraintDescriptor().getAnnotation().annotationType().getSimpleName(), violation.getMessage());
                result.put(map.get(arg), violation.getMessage());
            }
            throw new MethodValidationException(result);
        }
        return joinPoint.proceed();

    }


}
