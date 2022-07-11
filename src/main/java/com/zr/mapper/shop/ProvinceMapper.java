package com.zr.mapper.shop;

import com.zr.vo.shop.Province;

public interface ProvinceMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Province record);

    int insertSelective(Province record);

    Province selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Province record);

    int updateByPrimaryKey(Province record);
}