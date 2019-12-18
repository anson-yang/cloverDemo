package com.anson.service;

import com.anson.dao.UserMapper;
import com.anson.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserService
{
    @Autowired
    UserMapper usermapper;

    public int deleteByPrimaryKey(Integer id)
    {
        return   usermapper.deleteByPrimaryKey(id);
    }
    public  int insert(User record)
    {
        return  usermapper.insert(record);
    }
    public int insertSelective(User record)
    {
        return  usermapper.insertSelective(record);
    }
    public int updateByPrimaryKeySelective(User record)
    {
        return  usermapper.updateByPrimaryKeySelective(record);
    }
    public int updateByPrimaryKey(User record)
    {
        return  usermapper.updateByPrimaryKey(record);
    }


    //---------------@Cacheable with redis test----------------------
    //@Cacheable(cacheNames = "user")
    //@Cacheable(cacheNames = "user" ,key="#id")
    public User selectByPrimaryKey(Integer id)
    {
        return  usermapper.selectByPrimaryKey(id);
    }

    //@Cacheable(cacheNames = "users")
    public List<User> getAll()
    {
        return usermapper.getAll();
    }

}
