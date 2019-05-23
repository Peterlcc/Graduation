package com.peter.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.peter.bean.Recommand;

public interface RecommandMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Recommand record);

    int insertSelective(Recommand record);

    Recommand selectByPrimaryKey(Integer id);
    List<Recommand> selectByUser(@Param("userId")Integer userId,
    		@Param("area")String area);
    List<Recommand> selectRandomly(@Param("size")Integer size);

    int updateByPrimaryKeySelective(Recommand record);

    int updateByPrimaryKey(Recommand record);
}