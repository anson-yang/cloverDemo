package com.anson.controller;

import com.anson.common.result.ResultBody;
import com.anson.common.result.ResultCode;
import com.anson.model.User;
import com.anson.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @description: TODO
 * @author: anson
 * @Date: 2019/9/5 0:42
 * @version: 1.0
 */

@RestController
@Api(value = "API",tags = "API用户接口")
@RequestMapping("/user")
public class UserController
{
    @Autowired
    private UserService userservice;

    //1、根据ID获取单个用户
    @ApiOperation(value = "获取用户", notes = "根据id查询用户信息")
    @ApiImplicitParam(name = "id", value = "用户id", required=true, dataType="int") //API参数
    @RequestMapping(value="/getUserById/{id}",method= RequestMethod.GET)
    public User selectByPrimaryKey(@PathVariable int id)
    {
        return userservice.selectByPrimaryKey(id);
    }

    //2、获取所有用户
    @ApiOperation(value = "获取所有用户", notes = "获取所有用户")
    @RequestMapping(value="/getAll",method= RequestMethod.GET)
    public List<User> getAll()
    {
        return userservice.getAll();
    }

    //--------------------------------API test-------------------

    //1、根据ID获取单个用户
    @ApiOperation(value = "获取用户", notes = "根据id查询用户信息")
    @ApiImplicitParam(name = "id", value = "用户id", required=true, dataType="int") //API参数
    @RequestMapping(value="/user/{id}",method= RequestMethod.GET)
    public ResultBody getUserById(int id)
    {
        User user = userservice.selectByPrimaryKey(id);
        return  ResultBody.success(user,"获取单个信息成功");
    }

    //2、获取所有用户
    @ApiOperation(value = "获取所有用户", notes = "获取所有用户")
    @RequestMapping(value="/userall",method= RequestMethod.GET)
    public ResultBody getUserAll()
    {
        List<User> users = userservice.getAll();
        return  ResultBody.success(users,"获取所有用户信息成功");
    }

    //3、全局异常处理
    @ApiOperation(value = "ext", notes = "测试全局异常处理")
    @RequestMapping(value="/exception",method= RequestMethod.GET)
    public ResultBody exception()
    {
        try
        {
            throw new Exception("系统异常");
        }
        catch (Exception ex)
        {
        }
        return ResultBody.failed(ResultCode.FAILED);
    }

    //====================mongodb test==============
    /**表名*/
    private static final String collectionName = "user";

    @Autowired
    private MongoTemplate mongoTemplate;

    //增
    @ApiOperation(value = "mongodb增", notes = "mongodb增")
    @RequestMapping(value="/mongoadd",method= RequestMethod.GET)
    public ResultBody mongoAdd()
    {
        List<User> users = userservice.getAll();
        mongoTemplate.insertAll(users);
        return  ResultBody.success(users,"MongoDB写入成功");
    }


}
