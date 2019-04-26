package com.peter.mapper;

import java.util.List;

import com.peter.bean.Page;

public interface PageMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Page record);

    int insertSelective(Page record);

    Page selectByPrimaryKey(Integer id);
    List<Page> selectAll();

    int updateByPrimaryKeySelective(Page record);

    int updateByPrimaryKey(Page record);
}