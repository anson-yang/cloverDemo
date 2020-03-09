package com.anson.controller;

import com.anson.common.result.ResultBody;
import com.anson.common.result.ResultCode;
import com.fasterxml.jackson.databind.ser.Serializers;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description: TODO
 * @author: anson
 * @Date: 2019/12/20 6:13
 */
@RestController
public class MainControler extends BaseController
{
    //1、过滤器测试
    @ApiOperation(value = "failed", notes = "登录失败")
    @RequestMapping(value="/failed",method= RequestMethod.GET)
    public ResultBody exception()
    {

        log.info("登录失败");
        return ResultBody.failed(ResultCode.UNAUTHORIZED);
    }
}
