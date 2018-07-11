package com.sk.base.utils;

import org.apache.commons.lang.time.DateFormatUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * 订单号生成器
 */
@Component
public class OrderSeqUtil {

    @Autowired
    RedisTemplate<String, String> redisTemplate;


    /**
     * 获取订单号
     *
     * @param prefix
     */
    public String getOrderSeq(String prefix) {
        String date = DateFormatUtils.format(new Date(), "yyyyMMddHHmmss");
        Long increment = redisTemplate.opsForValue().increment("seq:" + date + ":" + prefix, 1);
        if (increment < 2) {
            redisTemplate.expire("seq:" + date + ":" + prefix, 20, TimeUnit.SECONDS);
        }
        return prefix + date + String.format("%04d", increment);
    }
}
