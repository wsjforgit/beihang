package com.sk.base.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.Charset;
import java.util.Map;

@Component
public class HttpUtils {
    private static org.slf4j.Logger logger = LoggerFactory.getLogger(HttpUtils.class);
    @Autowired
    @Lazy
    RestTemplate restTemplate;


    @Bean
    public ClientHttpRequestFactory simpleClientHttpRequestFactory() {
        SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
        factory.setReadTimeout(5000);//ms
        factory.setConnectTimeout(15000);//ms
        return factory;
    }

    @Bean
    public RestTemplate restTemplate(ClientHttpRequestFactory factory) {
        RestTemplate template = new RestTemplate(factory);
        template.getMessageConverters().add(0, new StringHttpMessageConverter(Charset.forName("utf-8")));
        return template;
    }


    public String post(String url, Map<String, String> params) {
        logger.info("ThreadId:{},url:{}", Thread.currentThread().getId(), url);
        HttpHeaders headers = new HttpHeaders();
        MediaType type = MediaType.parseMediaType("application/x-www-form-urlencoded");
        headers.setContentType(type);
        StringBuffer sb = new StringBuffer();
        for (Map.Entry<String, String> entry : params.entrySet()) {
            sb.append(entry.getKey() + "=" + entry.getValue() + "&");
        }
        sb.deleteCharAt(sb.length() - 1);
        logger.info("ThreadId:{},request:{}", Thread.currentThread().getId(), sb.toString());
        HttpEntity request = new HttpEntity(sb.toString(), headers);
        String result = restTemplate.postForObject(url, request, String.class);
        logger.info("ThreadId:{},response:{}", Thread.currentThread().getId(), result);
        return result;
    }

    public JSONObject postForJson(String url, Map<String, String> params) {

        return JSON.parseObject(post(url, params));
    }

    public String get(String url) {
        String result = restTemplate.getForObject(url, String.class);
        return result;
    }

    public void postJSON(String url, Map<String, String> params) {
        HttpHeaders headers = new HttpHeaders();
        MediaType type = MediaType.parseMediaType("application/json");
        headers.setContentType(type);
        HttpEntity request = new HttpEntity(params, headers);
        String result = restTemplate.postForObject(url, request, String.class);
    }

    public JSONObject getForJson(String url) {
        return JSON.parseObject(this.get(url));
    }
}
