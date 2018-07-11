package com.sk.p2p;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan(basePackages = {"com.sk.*.*.mapper", "com.sk.*.mapper"})
@ComponentScan(basePackages = {"com.sk"})
@EnableCaching
public class P2pCamera {

    public static void main(String[] args) {
        SpringApplication.run(P2pCamera.class, args);
    }
}
