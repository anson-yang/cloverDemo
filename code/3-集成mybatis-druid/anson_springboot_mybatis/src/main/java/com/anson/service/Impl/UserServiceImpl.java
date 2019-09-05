package com.anson.service.Impl;

        import com.anson.dao.UserMapper;
        import com.anson.model.User;
        import com.anson.service.UserService;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Service;

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
    public User selectByPrimaryKey(Integer id)
    {
        return  usermapper.selectByPrimaryKey(id);
    }
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

}
