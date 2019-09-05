package com.anson.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @description: CORS跨域配置类
 * @author: anson
 * @Date: 2019/9/5 14:54
 * @version: 1.0
 */

@Configuration
public class CORSConfiguration extends WebMvcConfigurationSupport
{
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedMethods("GET", "POST", "DELETE", "PUT","PATCH")
                .allowedOrigins("*")
                .maxAge(3600)
                .allowCredentials(true)
                .allowedHeaders("*");
        super.addCorsMappings(registry);
    }

//    @Bean
//    public WebMvcConfigurer corsConfigurer() {
//        return new WebMvcConfigurer() {
//            @Override
//            public void addCorsMappings(CorsRegistry registry) {
//                registry.addMapping("/**")
//                        .allowedOrigins("*")
//                        .allowCredentials(true)
//                        .allowedMethods("GET", "POST", "DELETE", "PUT","PATCH")
//                        .maxAge(3600);
//            }
//        };
//    }

}
