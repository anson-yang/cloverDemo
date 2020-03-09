package com.anson.controller;

import com.anson.common.result.ResultBody;
import com.anson.common.result.ResultCode;
import com.anson.model.User;
import com.anson.service.UserService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
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

//    //2、获取所有用户
//    @ApiOperation(value = "获取所有用户", notes = "获取所有用户")
//    @RequestMapping(value="/getAll",method= RequestMethod.GET)
//    public List<User> getAll()
//    {
//        return userservice.getAll();
//    }

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

//    //2、获取所有用户
//    @ApiOperation(value = "获取所有用户", notes = "获取所有用户")
//    @RequestMapping(value="/userall",method= RequestMethod.GET)
//    @LogAnnotation //自定义注解
//    public ResultBody getUserAll()
//    {
//           // throw new BizException(001,"登录失败了");
//            List<User> users = userservice.getAll();
//            return  ResultBody.success(users,"获取所有用户信息成功");
//
//
//    }

    //3、全局异常处理
    @ApiOperation(value = "ext", notes = "测试全局异常处理")
    @RequestMapping(value="/exception",method= RequestMethod.GET)
    public ResultBody exception()
    {

            logger.info("未知异常！原因是:info");
            logger.error("未知异常！原因是:error");
            logger.warn("未知异常！原因是:warn");
            int i =1/0;
        return ResultBody.failed(ResultCode.NOT_FOUND);
    }

    //====================mongodb test==============
    /**表名*/
    private static final String collectionName = "user";

    @Autowired
    private MongoTemplate mongoTemplate;

//    //增
//    @ApiOperation(value = "mongodb增", notes = "mongodb增")
//    @RequestMapping(value="/mongoadd",method= RequestMethod.GET)
//    public ResultBody mongoAdd()
//    {
//        List<User> users = userservice.getAll();
//        mongoTemplate.insertAll(users);
//        return  ResultBody.success(users,"MongoDB写入成功");
//    }

    //查
    @ApiOperation(value = "mongodb查", notes = "mongodb查")
    @ApiImplicitParam(name = "id", value = "用户id", required=true, dataType="int") //API参数
    @RequestMapping(value="/mongosearch/{id}",method= RequestMethod.GET)
    public ResultBody mongosearch(int id)
    {
        Query query = Query.query(Criteria.where("id").is(id));
        User user = this.mongoTemplate.find(query, User.class).get(0);

        return  ResultBody.success(user,"MongoDB写入成功");
    }

    //改

    @ApiOperation(value = "mongodb改", notes = "mongodb改")
    @ApiImplicitParam(name = "user", value = "用户信息", required=true, dataType="User",paramType = "body") //API参数
    @RequestMapping(value="/mongoupdate/",method= RequestMethod.POST)
    public ResultBody mongosearch(User user)
    {
        Query query = Query.query(Criteria.where("id").is(user.getId()));
                Update update = new Update();
                 update.set("username", user.getUsername());
                 update.set("password", user.getPassword());
                update.set("realname", user.getRealname());
                this.mongoTemplate.updateFirst(query, update, collectionName);

        return  ResultBody.success(user,"MongoDB修改成功");
    }

    //删
    @ApiOperation(value = "mongodb删", notes = "mongodb删")
    @ApiImplicitParam(name = "id", value = "用户id", required=true, dataType="int") //API参数
    @RequestMapping(value="/mongodelete",method= RequestMethod.GET)
    public ResultBody mongoDelete(int id)
    {

        Query query = Query.query(Criteria.where("id").is(id));
        this.mongoTemplate.remove(query, collectionName);
        return  ResultBody.success(id,"MongoDB删除成功");
    }


    //-----------mybatis plus--------------------
    //1、增
    @ApiOperation(value = "mybatis增", notes = "mybatis增")
    @RequestMapping(value="/add1",method= RequestMethod.GET)
    public ResultBody Add1()
    {
        User update = new User();
        update.setId(6);
        update.setUsername("王琦6");
        update.setPassword("1236216");
        update.setRealname("王琪琪6");
        //int insert = userservice.insert(update);
        userservice.save(update);

        return  ResultBody.success(update,"mybatis增--写入成功");
    }
    //2、删
    @ApiOperation(value = "mybatis删", notes = "mybatis删")
    @ApiImplicitParam(name = "id", value = "用户id", required=true, dataType="int") //API参数
    @RequestMapping(value="/del",method= RequestMethod.GET)
    public ResultBody del1(int id)
    {
        //int b = userservice.deleteByPrimaryKey(id);
        userservice.removeById(id);

        return  ResultBody.success(id,"mybatis删--成功");
    }
    //3、查
    @ApiOperation(value = "mybatis查", notes = "mybatis查")
    @ApiImplicitParam(name = "id", value = "用户id", required=true, dataType="int") //API参数
    @RequestMapping(value="/select",method= RequestMethod.GET)
    public ResultBody select1(int id)
    {
       // User b = userservice.selectByPrimaryKey(id);
        User b =userservice.getById(id);

        return  ResultBody.success(b,"mybatis查--成功");
    }
    //4、改
    @ApiOperation(value = "mybatis改", notes = "mybatis改")
    @RequestMapping(value="/update",method= RequestMethod.GET)
    public ResultBody update1()
    {
        User update = new User();
        update.setId(6);
        update.setUsername("alex2266");
       // int insert = userservice.updateByPrimaryKey(update);
        userservice.updateById(update);

        return  ResultBody.success(update,"mybatis改--写入成功");
    }
    //5、分页
    @ApiOperation(value = "mybatis分页", notes = "mybatis分页")
    @RequestMapping(value="/getpageall",method= RequestMethod.GET)
    public ResultBody mongoAdd1()
    {
        //Page page=new Page(1,3);          //1表示当前页，而10表示每页的显示显示的条目数
        //page = userservice.selectUserPage(page);

        IPage<User> page=new Page(1,3);
        page = userservice.page(page);





        //-----------------------------------------

        //1、根据条件删除
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper
                .isNull("username")
                .ge("id", 12)
                .isNotNull("realname");
        boolean delete = userservice.remove(queryWrapper);

        //2、根据条件查询
        QueryWrapper<User> queryWrapper2 = new QueryWrapper<>();
        queryWrapper2.eq("username", "eee");
        User user = userservice.getOne(queryWrapper2);

        //3、根据条件查询并分页
        Page<User> page2 = new Page<>(1, 5);
        QueryWrapper<User> queryWrapper3 = new QueryWrapper<>();
        queryWrapper3.like("username", "a");
        IPage<User> userIPage = userservice.page(page2, queryWrapper3);

        //4、根据条件更新

        User user2 = new User();
        user2.setRealname("zhangsan");

        UpdateWrapper<User> userUpdateWrapper = new UpdateWrapper<>();
        userUpdateWrapper.eq("username", "eee");

        boolean update = userservice.update(user, userUpdateWrapper);

        //----------------------------------------------

        return  ResultBody.success(page,"mybatis分页--写入成功");

    }


}
