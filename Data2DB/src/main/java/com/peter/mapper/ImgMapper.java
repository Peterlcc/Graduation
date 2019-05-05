package com.peter.mapper;

import java.util.List;

import com.peter.bean.Img;

public interface ImgMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Img record);

    int insertSelective(Img record);

    Img selectByPrimaryKey(Integer id);
    List<String> selectByHouseId(Integer houseId);

    int updateByPrimaryKeySelective(Img record);

    int updateByPrimaryKey(Img record);
}