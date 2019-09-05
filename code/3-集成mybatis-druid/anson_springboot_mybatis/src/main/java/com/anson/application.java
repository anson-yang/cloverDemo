package com.anson;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @description: TODO
 * @author: anson
 * @Date: 2019/9/4 23:02
 * @version: 1.0
 */

@SpringBootApplication   //添加启动类注解
@MapperScan("com.anson.dao")
public class application
{
    public static   void main(String[] args)
    {
        SpringApplication.run(application.class,args);
    }
}
