package anson.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description: user接口
 * @author: anson
 * @Date: 2019/9/3 21:33
 * @version: 1.0
 */

@Api(value = "用户接口")
@RestController
@RequestMapping("/user")
public class User
{
    /*
     * @Author anson
     * @Description 有参数的方法
     * @Date 2019/9/3 23:29
     * @Param [id]
     * @return java.lang.String
    */
    @ApiOperation(value = "获取用户", notes = "根据id查询用户信息")
    @ApiImplicitParam(name = "id", value = "用户id", required=true, dataType="String") //API参数
    @RequestMapping(value="/getUserById",method= RequestMethod.GET)
    public String getUser(String id)
    {
        return ("Hello anson-" + id);
    }

    /*
     * @Author anson
     * @Description 无参数的方法
     * @Date 2019/9/3 23:29
     * @Param []
     * @return java.lang.String
    */
    @ApiOperation(value = "获取用户", notes = "获取用户信息")
    @RequestMapping(value="/getUser",method= RequestMethod.GET)
    public String getUser()
    {
        return "Hello anson!";
    }
}
