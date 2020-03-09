package com.anson.service;

import com.anson.dao.UserMapper;
import com.anson.model.User;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService extends ServiceImpl<UserMapper, User>
{
    @Autowired
    UserMapper usermapper;

//    public int deleteByPrimaryKey(Integer id)
//    {
//        return   usermapper.deleteByPrimaryKey(id);
//    }
//    public  int insert(User record)
//    {
//        return  usermapper.insert(record);
//    }
//    public int insertSelective(User record)
//    {
//        return  usermapper.insertSelective(record);
//    }
//    public int updateByPrimaryKeySelective(User record)
//    {
//        return  usermapper.updateByPrimaryKeySelective(record);
//    }
//    public int updateByPrimaryKey(User record)
//    {
//        return  usermapper.updateByPrimaryKey(record);
//    }


    //---------------@Cacheable with redis test----------------------
    //@Cacheable(cacheNames = "user")
    //@Cacheable(cacheNames = "user" ,key="#id")
//    public User selectByPrimaryKey(Integer id)
//    {
//        return  usermapper.selectByPrimaryKey(id);
//    }

    //@Cacheable(cacheNames = "users")
//    public List<User> getAll()
//    {
//        return usermapper.getAll();
//    }
    //------------------



    public  Page<User> selectUserPage(Page<User> page)
    {
        page.setRecords(baseMapper.getAll(page));
        return page;
    }

    //增
    public  int insert(User record)
    {
        return  usermapper.insert(record);
    }
    //删
        public int deleteByPrimaryKey(Integer id)
    {
        return   usermapper.deleteById(id);
    }
    //查
        public User selectByPrimaryKey(Integer id)
    {
        return  usermapper.selectById(id);
    }
    //改
        public int updateByPrimaryKey(User record)
    {
        return  usermapper.updateById(record);
    }




}
