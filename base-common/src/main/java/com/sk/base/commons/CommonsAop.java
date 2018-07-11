package com.sk.base.commons;


import com.alibaba.fastjson.JSON;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * Created by YajieWang on 2016/5/9.
 */
@Component
@Aspect
public class CommonsAop {
    protected Logger log = LoggerFactory.getLogger(CommonsAop.class);

	 /* 处理异常,如果有异常那么不用图trycatch 自动返回异常消息
      系统自动处理*/

    @Around("execution(* com.afd.*.controller.*Controller.*(..))")
    public Object processException(ProceedingJoinPoint joinPoint) throws Throwable {
        long begin = System.currentTimeMillis();
        log.debug("接口:{},{}", joinPoint.getTarget().getClass().toString(), joinPoint.getSignature().getName());
        log.debug("参数:{}", Arrays.toString(joinPoint.getArgs()));
        Object obj = joinPoint.proceed();
        log.debug("<<=={}.{}", joinPoint.getTarget().getClass().toString(), joinPoint.getSignature().getName());
        log.debug("time:{},结果{}", (System.currentTimeMillis() - begin), JSON.toJSONString(obj));
        return obj;
    }


}
