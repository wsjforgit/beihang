package com.sk.base.utils.auth;

import java.lang.annotation.*;

/**
 * 不需要登录的注解
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface NoLogin {
    String value() default "";
}
