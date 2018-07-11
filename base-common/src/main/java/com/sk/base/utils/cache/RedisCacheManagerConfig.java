package com.sk.base.utils.cache;

import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.data.redis.cache.RedisCacheManager;
//import org.springframework.data.redis.core.RedisTemplate;

import java.io.IOException;

@Configuration
public class RedisCacheManagerConfig {
    @Bean(name = "redisCacheManager")
    public CacheManager cacheManager(@SuppressWarnings("rawtypes") RedisTemplate redisTemplate) throws IOException {
        RedisCacheManager manage = new RedisCacheManager(redisTemplate);
        manage.setUsePrefix(true);
        manage.setDefaultExpiration(60);
        return manage;
    }
}
