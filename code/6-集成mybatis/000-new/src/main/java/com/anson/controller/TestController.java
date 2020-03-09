package com.anson.controller;

import com.anson.common.annotation.LogAnnotation;
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
public class TestController extends BaseController
{

    @ApiOperation(value = "获取用户", notes = "获取用户信息")
    @RequestMapping(value="/test1",method= RequestMethod.GET)
    public String getUser()
    {
//        log.info("aaa");
//        log.error("bbb");
        return "Hello anson!";
    }

    @ApiOperation(value = "获取用户", notes = "获取用户信息")
    @RequestMapping(value="/test2",method= RequestMethod.GET)
    @LogAnnotation
    public String getUser2()
    {
//        log.info("aaa");
//        log.error("bbb");
        return "Hello anson2!";
    }
}
