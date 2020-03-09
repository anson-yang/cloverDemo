package com.anson.config;

import com.anson.common.interceptor.MyInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @description: 配置类
 * @author: anson
 * @Date: 2019/12/20 7:35
 */
@Configuration
public class AppConfigurer implements WebMvcConfigurer
{
    @Autowired
    private MyInterceptor myInterceptor;

    //注册拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(myInterceptor);
    }
}
