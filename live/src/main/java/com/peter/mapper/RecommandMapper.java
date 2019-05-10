package com.peter.mapper;

import java.util.List;

import com.peter.bean.Recommand;

public interface RecommandMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Recommand record);

    int insertSelective(Recommand record);

    Recommand selectByPrimaryKey(Integer id);
    List<Recommand> selectByUser(Integer userId);

    int updateByPrimaryKeySelective(Recommand record);

    int updateByPrimaryKey(Recommand record);
}