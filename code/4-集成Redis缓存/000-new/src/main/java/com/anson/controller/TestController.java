package com.anson.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @description: TODO
 * @author: anson
 * @Date: 2019/12/9 12:43
 */
@RestController
@RequestMapping("test")
public class TestController
{
    @Resource
    private RedisTemplate redisTemplate;

    @ApiOperation(value = "test", notes = "test")
    @RequestMapping(value="/test",method= RequestMethod.GET)
    public String test()
    {
        return "Hello anson!";
    }

    @ApiOperation(value = "写入缓存", notes = "写入缓存")
    @RequestMapping(value="/set",method= RequestMethod.GET)
    public String set()
    {
        redisTemplate.opsForValue().set("111","anson");
        return "写入缓存完毕";
    }

    @ApiOperation(value = "获取缓存", notes = "获取缓存")
    @RequestMapping(value="/get",method= RequestMethod.GET)
    public String get()
    {
        return redisTemplate.opsForValue().get("111").toString();
    }
}
