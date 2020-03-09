package com.anson;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * @description: TODO
 * @author: anson
 * @Date: 2019/12/9 12:46
 */
@SpringBootApplication
@MapperScan("com.anson.dao")
@ServletComponentScan("com.anson.common") //用于支持过滤器、监听器注解
public class application
{
    public static void main(String[] args)
    {
        SpringApplication.run(application.class);
    }
}
