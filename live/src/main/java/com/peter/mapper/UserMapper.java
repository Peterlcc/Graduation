package com.peter.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.peter.bean.User;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);
    
    List<User> selectByName(String name);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    
    int selectTotalRecord();
    List<User> selectAll(@Param("start") int start, @Param("size") int size);
}