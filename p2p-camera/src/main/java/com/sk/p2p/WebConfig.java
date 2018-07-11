package com.sk.p2p;

import org.springframework.beans.BeansException;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.servlet.MultipartConfigElement;

/**
 * 配置拦截器
 */
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter implements ApplicationContextAware {
    private ApplicationContext applicationContext;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
     /*   AdminSessionInterceptor bean = applicationContext.getBean(AdminSessionInterceptor.class);
        registry.addInterceptor(bean).addPathPatterns("/**");
        super.addInterceptors(registry);*/
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Bean
    MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        String osName = System.getProperty("os.name");
        if (osName.toLowerCase().contains("windows")) {
            factory.setLocation("D:\\temp");
        }
        return factory.createMultipartConfig();
    }

}
