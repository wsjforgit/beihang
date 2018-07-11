package com.sk.base.utils.auth;

import java.lang.annotation.*;

/**
 * Created by WangYa on 2017/8/6.
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented

public @interface Auth {
    String value() default "";
}
