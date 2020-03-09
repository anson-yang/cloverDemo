package com.anson.dao;

import com.anson.model.User;
//import org.apache.ibatis.annotations.Mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
//import javafx.scene.control.Pagination;
import javafx.scene.control.Pagination;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.List;

@Repository
//@Mapper
public interface UserMapper extends BaseMapper<User>
{
  //  int deleteByPrimaryKey(Integer id);

    //int insert(User record);

   // int insertSelective(User record);

   // User selectByPrimaryKey(Integer id);

   // int updateByPrimaryKeySelective(User record);

   // int updateByPrimaryKey(User record);

    //List<User> getAll();

    //@Select("getAll")
    List<User> getAll(Page page);
}