package com.anson.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description: TODO
 * @author: anson
 * @Date: 2019/12/9 12:43
 */
@RestController
@RequestMapping("test")
public class TestController
{

    @ApiOperation(value = "获取用户", notes = "获取用户信息")
    @RequestMapping(value="/test",method= RequestMethod.GET)
    public String getUser()
    {
        return "Hello anson!";
    }
}
