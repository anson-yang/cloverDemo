package com.anson.service.Impl;

        import com.anson.dao.UserMapper;
        import com.anson.model.User;
        import com.anson.service.UserService;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.cache.annotation.Cacheable;
       // import org.springframework.data.redis.core.RedisTemplate;
        import org.springframework.stereotype.Service;

        import java.util.*;

/**
 * @description: TODO
 * @author: anson
 * @Date: 2019/9/5 0:37
 * @version: 1.0
 */
@Service
public class UserServiceImpl implements UserService
{
    @Autowired
    UserMapper usermapper;

    @Override
    public int deleteByPrimaryKey(Integer id)
    {
        return   usermapper.deleteByPrimaryKey(id);
    }
    @Override
    public  int insert(User record)
    {
        return  usermapper.insert(record);
    }
    @Override
    public int insertSelective(User record)
    {
        return  usermapper.insertSelective(record);
    }
    @Override
    public int updateByPrimaryKeySelective(User record)
    {
        return  usermapper.updateByPrimaryKeySelective(record);
    }
    @Override
    public int updateByPrimaryKey(User record)
    {
        return  usermapper.updateByPrimaryKey(record);
    }


    //---------------@Cacheable with redis test----------------------
    //    @Override
    //    @Cacheable(cacheNames = "user")
    @Override
    @Cacheable(cacheNames = "user" ,key="#id")
    public User selectByPrimaryKey(Integer id)
    {
        return  usermapper.selectByPrimaryKey(id);
    }

    @Override
    @Cacheable(cacheNames = "users")
    public List<User> getAll()
    {
        return usermapper.getAll();
    }


}
